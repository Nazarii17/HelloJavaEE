package nazarii.tkachuk.com.dao;


import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.providers.ConnectionManager;
import nazarii.tkachuk.com.providers.JdbcConnectionProvider;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao implements DAO<Product> {

    @Override
    public Optional<Product> getByID(int id) {

        String sql = "select id, name, price, info, discount, category_id, quantity " +
                "from drugstoredb.product " +
                "where id = " + id + ";";

        ResultSet resultSet;
        Product product = null;

        try {
//            resultSet = JdbcConnectionProvider.getPreparedStation(sql).executeQuery();
            resultSet = ConnectionManager.getConnection().prepareStatement(sql).executeQuery();

            while (resultSet.next()) {
                product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        BigDecimal.valueOf(Double.parseDouble(resultSet.getString("price"))),
                        resultSet.getString("info"),
                        resultSet.getInt("discount"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(product);
    }

    @Override
    public List<Product> getAll() {

        String sql = "SELECT t.* FROM drugstoredb.product t;";

        ResultSet resultSet;
        PreparedStatement preparedStatement;
        List<Product> productList = new ArrayList<>();
        try {
//            resultSet = JdbcConnectionProvider.getPreparedStation(sql).executeQuery();

            resultSet = ConnectionManager.getConnection().prepareStatement(sql).executeQuery();

            while (resultSet.next()) {
                productList.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        BigDecimal.valueOf(Double.parseDouble(resultSet.getString("price"))),
                        resultSet.getString("info"),
                        resultSet.getInt("discount"),
                        resultSet.getInt("category_id"),
                        resultSet.getInt("quantity")
                ));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        if (productList.isEmpty()) {
            throw new RuntimeException("Got nothing from db!");
        }
        return productList;
    }

    @Override
    public void save(Product product) {

        String sql = "INSERT INTO `drugstoredb`.`product` (`name`, `price`, `info`, `discount`, `category_id`, `quantity`) VALUES ( ?, ?, ?, ?, ?, ?)";

//        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int rowsInserted = 0;
        try {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice().setScale(2, RoundingMode.HALF_UP).toString());
            preparedStatement.setString(3, product.getInfo());
            preparedStatement.setString(4, product.getDiscount().toString());
            preparedStatement.setString(5, product.getCategoryID().toString());
            preparedStatement.setString(6, product.getQuantity().toString());

            rowsInserted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }

    @Override
    public void update(Product product, String[] params) {

        String sql = "UPDATE `drugstoredb`.`product` t SET " +
                "t.`name` = ?, " +
                "t.`price` = ?, " +
                "t.`info` = ?, " +
                "t.`discount` = ?, " +
                "t.`category_id` = ?, " +
                "t.`quantity` = ? " +
                "WHERE t.`id` = " + product.getId() + ";";

        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);

        try {
            preparedStatement.setString(1, params[0]);
            preparedStatement.setBigDecimal(2, new BigDecimal(params[1]));
            preparedStatement.setString(3, params[2]);
            preparedStatement.setShort(4, Short.valueOf(params[3]));
            preparedStatement.setInt(5, Integer.parseInt(params[4]));
            preparedStatement.setInt(6, Integer.parseInt(params[5]));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Product product) {

        String sql = "UPDATE `drugstoredb`.`product` t SET " +
                "t.`name` = ?, " +
                "t.`price` = ?, " +
                "t.`info` = ?, " +
                "t.`discount` = ?, " +
                "t.`category_id` = ?, " +
                "t.`quantity` = ? " +
                "WHERE t.`id` = " + product.getId() + ";";

//        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setBigDecimal(2, product.getPrice());
            preparedStatement.setString(3, product.getInfo());
            preparedStatement.setShort(4, Short.valueOf(String.valueOf(product.getDiscount())));
            preparedStatement.setInt(5, Integer.valueOf(String.valueOf(product.getCategoryID())));
            preparedStatement.setInt(6, product.getQuantity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product product) {

        String sql = "DELETE FROM `drugstoredb`.`product` WHERE `id` = ?";

        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);
        try {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByID(Integer id) {

        String sql = "DELETE FROM `drugstoredb`.`product` WHERE `id` = ?";

//        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionManager.getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByName(String name) {

        String sql = "DELETE FROM `drugstoredb`.`product` WHERE `name` = ?";

        PreparedStatement preparedStatement = JdbcConnectionProvider.getPreparedStation(sql);
        try {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
