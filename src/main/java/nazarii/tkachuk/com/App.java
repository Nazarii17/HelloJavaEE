package nazarii.tkachuk.com;

import nazarii.tkachuk.com.dao.CategoryDao;
import nazarii.tkachuk.com.dao.CustomerDao;
import nazarii.tkachuk.com.dao.OrderDao;
import nazarii.tkachuk.com.dao.ProductDao;
import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.OrderService;
import nazarii.tkachuk.com.services.ProductService;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        CustomerDao customerDao = new CustomerDao();
        ProductDao productDao = new ProductDao();
        OrderDao orderDao = new OrderDao();
        CategoryDao categoryDao = new CategoryDao();

//        productService.save("Protein15545",new BigDecimal("25.5"), "Strong",0);

//        customerService.deleteByEmail("kitty@mail.com");
        System.out.println(productService.getAll());
//        productService.deleteByID(27);
        System.out.println(productService.getByID(1));

        System.out.println(categoryDao.getAll());
        Product product= productService.getByID(39);
        product.setName("qqqqqqqq");
        product.setPrice(new BigDecimal(55.33));
        product.setInfo("uuuuuuuuu");
        product.setQuantity(1111);
        product.setCategoryID(3);
        product.setDiscount(99);
        System.out.println( product );
        productService.update(product);




    }
}
