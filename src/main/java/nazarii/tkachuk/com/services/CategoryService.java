package nazarii.tkachuk.com.services;

import nazarii.tkachuk.com.dao.CategoryDao;
import nazarii.tkachuk.com.entities.Category;

import java.util.List;

public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();

    public List<Category> getAll() {
        return categoryDao.getAll();
    }

}
