package nazarii.tkachuk.com.servlets;

import nazarii.tkachuk.com.entities.Category;
import nazarii.tkachuk.com.entities.Customer;
import nazarii.tkachuk.com.entities.Order;
import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.services.CategoryService;
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

@WebServlet(name = "InfoOrderServlet", value = "/order/info")
public class InfoOrderServlet extends HttpServlet {
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
        int orderID = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.getByID(orderID);
        request.setAttribute("order",order);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/showOrder.jsp");
        requestDispatcher.forward(request,response);

    }
}
