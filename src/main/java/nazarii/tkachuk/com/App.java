package nazarii.tkachuk.com;

import nazarii.tkachuk.com.dao.CategoryDao;
import nazarii.tkachuk.com.dao.CustomerDao;
import nazarii.tkachuk.com.dao.OrderDao;
import nazarii.tkachuk.com.dao.ProductDao;
import nazarii.tkachuk.com.entities.Category;
import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.services.CategoryService;
import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.OrderService;
import nazarii.tkachuk.com.services.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        CategoryService categoryService = new CategoryService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        CustomerDao customerDao = new CustomerDao();
        CategoryDao categoryDao = new CategoryDao();
        ProductDao productDao = new ProductDao();
        OrderDao orderDao = new OrderDao();

        List<Product> productList = productService.getAll();


        for (Product product : productList) {

            System.out.println(product.getId());
//            System.out.println(product.getName());
//            System.out.println(product.getPrice());
//            System.out.println(product.getDiscount());
//            System.out.println(product.getQuantity());


            for (Category category : categoryService.getAll()) {
                if (category.getId().equals(product.getCategoryID())) {
                    System.out.println(category.getName());


                }


            }
        }
    }
}
