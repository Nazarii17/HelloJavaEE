package nazarii.tkachuk.com.servlets;

import nazarii.tkachuk.com.entities.Category;
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
import java.util.List;

@WebServlet(name = "InfoProductServlet", value = "/product/info")
public class InfoProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.getAll();
        request.setAttribute("categoryList", categoryList);

        ProductService productService = new ProductService();
        int productID = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getByID(productID);
        request.setAttribute("product",product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/showProduct.jsp");
        requestDispatcher.forward(request,response);

    }
}
