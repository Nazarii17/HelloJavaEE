package nazarii.tkachuk.com.servlets;

import nazarii.tkachuk.com.entities.Customer;
import nazarii.tkachuk.com.services.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCustomerServlet", value = "/customer/add")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerService customerService = new CustomerService();

        Customer customer = new Customer(
                request.getParameter("name"),
                request.getParameter("lastname"),
                request.getParameter("phonenumber"),
                request.getParameter("email"));

        customerService.save(customer);

        response.sendRedirect("/customer/all");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/addCustomer.jsp");
        requestDispatcher.forward(request, response);
    }
}
