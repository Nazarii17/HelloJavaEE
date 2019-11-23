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
import java.util.List;

@WebServlet(name = "AllCustomersListServlet", value = "/customer/all")
public class AllCustomersListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        List<Customer> customerList = customerService.getAll();
        request.setAttribute("customerList",customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/allCustomers.jsp");
        requestDispatcher.forward(request,response);
    }
}
