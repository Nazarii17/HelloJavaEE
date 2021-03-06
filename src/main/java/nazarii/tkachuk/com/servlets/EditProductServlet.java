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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.rmi.Remote;
import java.util.List;

@WebServlet(name = "EditProductServlet", value = "/product/edit")
public class EditProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductService();

        Product product = new Product(

                request.getParameter("name"),
                new BigDecimal((request.getParameter("price"))).setScale(2, RoundingMode.HALF_UP),
                request.getParameter("info"),
                Integer.parseInt(request.getParameter("discount")),
                Integer.parseInt(request.getParameter("categoryID")),
                Integer.parseInt(request.getParameter("quantity")));

        int productID = Integer.parseInt(request.getParameter("id"));
        product.setId(productID);

        System.out.println(product);

        productService.update(product);

        response.sendRedirect("/product/all");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.getAll();
        request.setAttribute("categoryList", categoryList);

        ProductService productService = new ProductService();
        int productID = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getByID(productID);
        System.out.println(product);

        request.setAttribute("product",product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/editProduct.jsp");
        requestDispatcher.forward(request,response);

        response.sendRedirect("/product/all");

    }
}
