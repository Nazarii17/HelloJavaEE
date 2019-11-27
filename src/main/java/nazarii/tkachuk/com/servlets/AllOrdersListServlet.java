package nazarii.tkachuk.com.servlets;

import nazarii.tkachuk.com.entities.Customer;
import nazarii.tkachuk.com.entities.Order;
import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.OrderService;
import nazarii.tkachuk.com.services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllOrdersListServlet", value = "/order/all")
public class AllOrdersListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductService();
        List<Product> productList = productService.getAll();
        request.setAttribute("productList", productList);

        CustomerService customerService = new CustomerService();
        List<Customer> customerList = customerService.getAll();
        request.setAttribute("customerList", customerList);

        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.getAll();
        request.setAttribute("orderList",orderList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/allOrders.jsp");
        requestDispatcher.forward(request,response);
    }
}
