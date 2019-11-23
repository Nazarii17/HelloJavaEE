package nazarii.tkachuk.com.servlets;

import nazarii.tkachuk.com.entities.Category;
import nazarii.tkachuk.com.entities.Person;
import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.services.CategoryService;
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

@WebServlet(name = "AddProductServlet", value = "/product/add")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductService();

        Product product = new Product(
                request.getParameter("name"),
                new BigDecimal((request.getParameter("price"))).setScale(2,RoundingMode.HALF_UP),
                request.getParameter("info"),
                Integer.parseInt(request.getParameter("discount")),
                Integer.parseInt(request.getParameter("categoryID")),
                Integer.parseInt(request.getParameter("quantity")));

        System.out.println(product);

        productService.save(product);

        response.sendRedirect("/product/all");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.getAll();
        request.setAttribute("categoryList", categoryList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp" );
        requestDispatcher.forward(request, response);
    }
}
