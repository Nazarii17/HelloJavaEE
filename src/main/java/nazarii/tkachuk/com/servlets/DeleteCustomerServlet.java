package nazarii.tkachuk.com.servlets;

import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteProductServlet", value = "/customer/delete")
public class DeleteCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();

        int customerID = Integer.parseInt(request.getParameter("id"));

        customerService.deleteByID(customerID);
        response.sendRedirect("/customer/all");
    }
}
