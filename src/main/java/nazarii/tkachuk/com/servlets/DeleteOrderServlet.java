package nazarii.tkachuk.com.servlets;

import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteOrderServlet", value = "/order/delete")
public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService orderService = new OrderService();

        int orderID = Integer.parseInt(request.getParameter("id"));

        orderService.deleteByID(orderID);
        response.sendRedirect("/order/all");
    }
}
