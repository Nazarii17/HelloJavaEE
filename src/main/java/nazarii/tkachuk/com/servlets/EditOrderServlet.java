package nazarii.tkachuk.com.servlets;

import nazarii.tkachuk.com.entities.Category;
import nazarii.tkachuk.com.entities.Customer;
import nazarii.tkachuk.com.entities.Order;
import nazarii.tkachuk.com.entities.Product;
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
import java.util.List;

@WebServlet(name = "EditOrderServlet", value = "/order/edit")
public class EditOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityIDService entityIDService = new EntityIDService();
        OrderService orderService = new OrderService();

        Order order;

        order = new Order(
                java.sql.Timestamp.valueOf(entityIDService.parseDate(request.getParameter("orderDate"))),
                Integer.parseInt(request.getParameter("quantity")),
                Integer.parseInt(request.getParameter("customerID")),
                Integer.parseInt(request.getParameter("productID")),
                new BigDecimal((request.getParameter("price"))).setScale(2, RoundingMode.HALF_UP)
        );

        int orderID = Integer.parseInt(request.getParameter("id"));
        order.setId(orderID);

        orderService.update(order);

        response.sendRedirect("/order/all");
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

        request.setAttribute("order", order);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/editOrder.jsp");
        requestDispatcher.forward(request, response);

        response.sendRedirect("/order/all");

    }
}
