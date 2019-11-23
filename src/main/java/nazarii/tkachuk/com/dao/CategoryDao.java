package nazarii.tkachuk.com.dao;

import nazarii.tkachuk.com.entities.Category;
import nazarii.tkachuk.com.providers.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDao implements DAO<Category> {
    @Override
    public Optional<Category> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public List<Category> getAll() {

        String sql = "SELECT t.* FROM drugstoredb.category t;";

        ResultSet resultSet;
        PreparedStatement preparedStatement;
        List<Category> categoryList = new ArrayList<>();
        try {
//            resultSet = JdbcConnectionProvider.getPreparedStation(sql).executeQuery();

            resultSet = ConnectionManager.getConnection().prepareStatement(sql).executeQuery();


            while (resultSet.next()) {
                categoryList.add(new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                ));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        if (categoryList.isEmpty()) {
            throw new RuntimeException("Got nothing from db!");
        }
        return categoryList;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void update(Category category, String[] params) {

    }

    @Override
    public void delete(Category category) {

    }
}
