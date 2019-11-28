package nazarii.tkachuk.com.servlets;

import nazarii.tkachuk.com.entities.*;
import nazarii.tkachuk.com.services.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "AddOrderServlet", value = "/order/add")
public class AddOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityIDService entityIDService = new EntityIDService();
        OrderService orderService = new OrderService();

        System.out.println(entityIDService.parseDate(request.getParameter("orderDate")));

        Order order;

        order = new Order(
                java.sql.Timestamp.valueOf(entityIDService.parseDate(request.getParameter("orderDate"))),
                Integer.parseInt(request.getParameter("quantity")),
                Integer.parseInt(request.getParameter("customerID")),
                Integer.parseInt(request.getParameter("productID")),
                new BigDecimal((request.getParameter("price"))).setScale(2, RoundingMode.HALF_UP)
        );

        System.out.println(order);
        orderService.save(order);

        response.sendRedirect("/order/all");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductService();
        List<Product> productList = productService.getAll();
        request.setAttribute("productList", productList);

        CustomerService customerService = new CustomerService();
        List<Customer> customerList = customerService.getAll();
        request.setAttribute("customerList", customerList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/addOrder.jsp");
        requestDispatcher.forward(request, response);
    }
}
