package nazarii.tkachuk.com;

import nazarii.tkachuk.com.dao.CustomerDAO;
import nazarii.tkachuk.com.dao.OrderDao;
import nazarii.tkachuk.com.dao.ProductDAO;
import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.OrderService;
import nazarii.tkachuk.com.services.ProductService;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDao orderDao = new OrderDao();

//        productService.save("Protein15545",new BigDecimal("25.5"), "Strong",0);

//        customerService.deleteByEmail("kitty@mail.com");
        System.out.println(productService.getAll());
//        productService.deleteByID(27);
        System.out.println(productService.getByID(1));




    }
}
