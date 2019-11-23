package nazarii.tkachuk.com.servlets;

import nazarii.tkachuk.com.entities.Category;
import nazarii.tkachuk.com.entities.Customer;
import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.services.CategoryService;
import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.ProductService;

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

@WebServlet(name = "EditCustomerServlet", value = "/customer/edit")
public class EditCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerService customerService = new CustomerService();

        Customer customer = new Customer(
                request.getParameter("name"),
                request.getParameter("lastname"),
                request.getParameter("phonenumber"),
                request.getParameter("email")
                );

        int customerID = Integer.parseInt(request.getParameter("id"));
        customer.setId(customerID);

        customerService.update(customer);

        response.sendRedirect("/customer/all");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerService customerService = new CustomerService();
        int customerID = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.getByID(customerID);

        request.setAttribute("customer",customer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/editCustomer.jsp");
        requestDispatcher.forward(request,response);

        response.sendRedirect("/customer/all");

    }
}
