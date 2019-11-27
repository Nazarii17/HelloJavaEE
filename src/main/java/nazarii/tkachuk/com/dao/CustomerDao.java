package nazarii.tkachuk.com.dao;

import nazarii.tkachuk.com.entities.Customer;
import nazarii.tkachuk.com.providers.ConnectionManager;
import nazarii.tkachuk.com.providers.JdbcProvider;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements DAO<Customer> {

    @Override
    public Optional<Customer> getByID(int id) {

//        //c3p0 - не праює через проперті
//        Customer customer = JdbcProvider.getJdbcTemplate().queryForObject(
//                "select id, name, lastName, phoneNumber, email " +
//                        "from drugstoredb.customer " +
//                        "where id = " + id + ";",
//                BeanPropertyRowMapper.newInstance(Customer.class));
//
//        return Optional.of(customer);
        String sql = "select id, name, lastName, phoneNumber, email " +
                "from drugstoredb.customer " +
                "where id = " + id + ";";

        ResultSet resultSet;
        Customer customer = null;

        try {
            resultSet = ConnectionManager.getConnection().prepareStatement(sql).executeQuery();

            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(customer);
    }

    @Override
    public List<Customer> getAll() {
//        List<Customer> customers = JdbcProvider.getJdbcTemplate().query(
//                "select id, name, lastName, phoneNumber, email from customer;",
//                new BeanPropertyRowMapper(Customer.class));
//        return customers;
        String sql = "SELECT t.* FROM drugstoredb.customer t;";

        ResultSet resultSet;
        PreparedStatement preparedStatement;
        List<Customer> customerList = new ArrayList<>();

        try {
            resultSet = ConnectionManager.getConnection().prepareStatement(sql).executeQuery();

            while (resultSet.next()) {
                customerList.add(new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (customerList.isEmpty()) {
            throw new RuntimeException("Got nothing from db!");
        }
        return customerList;
    }

    //    @Override
//    public List<Customer> getAll() {
//        List<Customer> customers = JdbcProvider.getJdbcTemplate().query(
//                "SELECT * FROM CUSTOMER;",
//                new BeanPropertyRowMapper(Customer.class));
//        return customers;
//    }
    @Override
    public void save(Customer customer) {

        String sql = "INSERT INTO `customer` (`name`, `lastName`, `phoneNumber`, `email`) VALUES ( ?, ?, ?, ?)";

        JdbcProvider.getJdbcTemplate().update(sql,
                customer.getName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail()
        );
    }

    @Override
    public void update(Customer customer, String[] params) {

        String sql = "UPDATE `drugstoredb`.`customer` t SET " +
                "t.`name` = ?, " +
                "t.`lastName` = ?, " +
                "t.`phoneNumber` = ?, " +
                "t.`email` = ? " +
                "WHERE t.`id` = " + customer.getId() + ";";
//                new Object[]{
//                customer.getName(),
//                customer.getLastName(),
//                customer.getPhoneNumber(),
//                customer.getEmail(),
//                customer.getId()};
        JdbcProvider.getJdbcTemplate().update(sql, params);
    }

    public void update(Customer customer) {
//        String s = "UPDATE `drugstoredb`.`customer` t SET " +
//                "t.`name` = '" + customer.getName() + "', " +
//                "t.`lastName` = '" + customer.getLastName() + "', " +
//                "t.`phoneNumber` = '" + customer.getPhoneNumber() + "', " +
//                "t.`email` = '" + customer.getEmail() + "' " +
//                "WHERE t.`id` = " + customer.getId() + ";";
//
//        JdbcProvider.getJdbcTemplate().update(s);
        String sql = "UPDATE `drugstoredb`.`customer` t SET " +
                "t.`name` = ?, " +
                "t.`lastName` = ?, " +
                "t.`phoneNumber` = ?, " +
                "t.`email` = ? " +
                "WHERE t.`id` = ?;";

        JdbcProvider.getJdbcTemplate().update(sql,
                customer.getName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getId());
    }

    @Override
    public void delete(Customer customer) {
        deleteByID(customer.getId());
    }

    public boolean deleteByID(Integer id) {
        String sql = "DELETE FROM `drugstoredb`.`customer` WHERE `id` = ?";

        return JdbcProvider.getJdbcTemplate().update(sql, id) == 1;
    }

    public boolean deleteByPhoneNumber(String phoneNumber) {
        String sql = "DELETE FROM `drugstoredb`.`customer` WHERE `phoneNumber` = ?";
        Object[] args = new Object[]{phoneNumber};

        return JdbcProvider.getJdbcTemplate().update(sql, args) == 1;
    }

    public boolean deleteByEmail(String email) {
        String sql = "DELETE FROM `drugstoredb`.`customer` WHERE `email` = ?";

        return JdbcProvider.getJdbcTemplate().update(sql, email) == 1;
    }
}
