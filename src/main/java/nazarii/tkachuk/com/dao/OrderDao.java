package nazarii.tkachuk.com.dao;

import nazarii.tkachuk.com.entities.Order;
import nazarii.tkachuk.com.providers.JdbcConnectionProvider;
import nazarii.tkachuk.com.services.ProductService;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDao implements DAO<Order> {

    private ProductService productService = new ProductService();

    @Override
    public Optional<Order> getByID(int id) {

        String sql = "select id, orderDate, quantity, customer_id, product_id, price " +
                "from drugstoredb.order " +
                "where id = " + id + ";";

        ResultSet resultSet;
        Order order = null;

        try {
            resultSet = JdbcConnectionProvider.getPreparedStation(sql).executeQuery();

            while (resultSet.next()) {
                order = new Order(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("orderDate"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("product_id"),
                        resultSet.getBigDecimal("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(order);
    }

    @Override
    public List<Order> getAll() {

        String sql = "SELECT t.* FROM drugstoredb.`order` t;";
        ResultSet resultSet;
        List<Order> orders = new ArrayList<>();

        try {
            resultSet = JdbcConnectionProvider.getPreparedStation(sql).executeQuery();

            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("orderDate"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("product_id"),
                        resultSet.getBigDecimal("price"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (orders.isEmpty()) {
            throw new RuntimeException("Got nothing from db!");
        }
        return orders;
    }

    public List<Order> getAllByDate(String date){
        String sql = "SELECT t.* FROM drugstoredb.`order` t " +
                "where  t.orderDate = '"+date+"';";
        ResultSet resultSet;
        List<Order> orders = new ArrayList<>();

        try {
            resultSet = JdbcConnectionProvider.getPreparedStation(sql).executeQuery();

            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("orderDate"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("product_id"),
                        resultSet.getBigDecimal("price"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (orders.isEmpty()) {
            throw new RuntimeException("Got nothing from db!");
        }
        return orders;
    }

    @Override
    public void save(Order order) {
        String sql = "INSERT INTO `drugstoredb`.`order` " +
                "(`orderDate`, `quantity`, `customer_id`, `product_id`, `price`) " +
                "VALUES ( ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);

        BigDecimal price = BigDecimal.valueOf(order.getQuantity()).multiply(productService.getByID(order.getProductID()).getPrice());

        try {
            preparedStatement.setTimestamp(1, order.getOrderDate());
            preparedStatement.setInt(2, order.getQuantity());
            preparedStatement.setInt(3, order.getCustomerID());
            preparedStatement.setInt(4, order.getProductID());
            preparedStatement.setBigDecimal(5, price);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order order, String[] params) {

        String sql = "UPDATE `drugstoredb`.`order` t SET " +
                "t.`orderDate` = ?, " +
                "t.`quantity` = ?, " +
                "t.`customer_id` = ?, " +
                "t.`product_id` = ?, " +
                "t.`price` = ? " +
                "WHERE t.`id` = " + order.getId() + ";";

        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);

        try {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(params[0]));
            preparedStatement.setInt(2, Integer.parseInt(params[1]));
            preparedStatement.setInt(3, Integer.parseInt(params[2]));
            preparedStatement.setInt(4, Integer.parseInt(params[3]));
            preparedStatement.setBigDecimal(5, new BigDecimal(params[4]) );

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Order order) {

        String sql = "UPDATE `drugstoredb`.`order` t SET " +
                "t.`orderDate` = ?, " +
                "t.`quantity` = ?, " +
                "t.`customer_id` = ?, " +
                "t.`product_id` = ?, " +
                "t.`price` = ? " +
                "WHERE t.`id` = " + order.getId() + ";";

        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);

        try {
            preparedStatement.setTimestamp(1, order.getOrderDate());
            preparedStatement.setInt(2, order.getQuantity());
            preparedStatement.setInt(3, order.getCustomerID());
            preparedStatement.setInt(4, order.getProductID());
            preparedStatement.setBigDecimal(5, order.getPrice());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Order order) {

        String sql = "DELETE FROM `drugstoredb`.`order` WHERE `id` = ?";

        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);

        try {
            preparedStatement.setInt(1,order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByID(Integer id) {

        String sql = "DELETE FROM `drugstoredb`.`order` WHERE `id` = ?";

        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);

        try {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByDate(String date) {

        String sql = "DELETE FROM `drugstoredb`.`order` WHERE `orderDate` = ?";

        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);

        try {
            preparedStatement.setString(1,date);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
