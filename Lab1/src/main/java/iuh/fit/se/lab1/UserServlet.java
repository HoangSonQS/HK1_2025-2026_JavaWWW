package iuh.fit.se.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Khai báo init-param trong Annotation
@WebServlet(
        name = "UserServlet",
        urlPatterns = {"/userServlet"},
        initParams = {
                @WebInitParam(name = "name", value = "Hoang Son"),
                @WebInitParam(name = "email", value = "Not provided")
        }
)
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // Lấy và hiển thị init-param
        String name = getInitParameter("name");
        String email = getInitParameter("email");

        // Lấy và hiển thị context-param
        String province = getServletContext().getInitParameter("province");
        String country = getServletContext().getInitParameter("country");

        out.println("<html><body>");
        out.println("<h2>Using Init Parameters</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");

        out.println("<h2>Using Context Parameters</h2>");
        out.println("<p>Province: " + province + "</p>");
        out.println("<p>Country: " + country + "</p>");
        out.println("</body></html>");
    }
}