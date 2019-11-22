package nazarii.tkachuk.com.services;

import nazarii.tkachuk.com.dao.ProductDAO;
import nazarii.tkachuk.com.entities.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProductService {

    ProductDAO productDAO = new ProductDAO();

    public Product getByID(int id) {
        return productDAO.getByID(id).get();
    }

    public List<Product> getAll() {
        return productDAO.getAll();
    }

    public void save(Product product) {
        productDAO.save(product);
    }

    public void save(String name,
                     BigDecimal price,
                     String info,
                     Integer discount) {
        productDAO.save(new Product(name, price.setScale(2, RoundingMode.HALF_EVEN), info, discount));
    }

    public void update(Product product) {
        productDAO.update(product);
    }

    public void update(Product product, String[] params) {
        productDAO.update(product, params);
    }

    public void update(Product product,
                       String name,
                       BigDecimal price,
                       String info,
                       Integer discount) {
        String[] params = new String[]{
                name,
                price.toString(),
                info,
                discount.toString()};
        productDAO.update(product, params);
    }

    public void update(Integer id,
                       String name,
                       BigDecimal price,
                       String info,
                       Integer discount) {
        Product product = new Product(id);
        String[] params = new String[]{
                name,
                price.toString(),
                info,
                discount.toString()};
        productDAO.update(product, params);
    }

    public void delete(Product product){
        productDAO.delete(product);
    }

    public void deleteByID(Integer id){
        productDAO.deleteByID(id);
    }

    public void deleteByName(String name){
        productDAO.deleteByName(name);
    }
}
