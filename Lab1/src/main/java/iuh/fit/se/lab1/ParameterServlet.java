package iuh.fit.se.lab1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "ParameterServlet",
        urlPatterns = {"/params"},
        initParams = {
                @WebInitParam(name = "appName", value = "My Web App"),
                @WebInitParam(name = "version", value = "1.0")
        }
)
public class ParameterServlet extends HttpServlet {

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

        // Lấy Init-Param của Servlet này
        String appName = getInitParameter("appName");
        String version = getInitParameter("version");

        // Lấy Context-Param của toàn bộ ứng dụng
        ServletContext context = getServletContext();
        String developerName = context.getInitParameter("developerName");
        String contactEmail = context.getInitParameter("contactEmail");

        out.println("<html><body>");
        out.println("<h2>Servlet Init Parameters</h2>");
        out.println("<p>Application Name: " + appName + "</p>");
        out.println("<p>Version: " + version + "</p>");
        out.println("<hr>");
        out.println("<h2>Application Context Parameters</h2>");
        out.println("<p>Developer Name: " + developerName + "</p>");
        out.println("<p>Contact Email: " + contactEmail + "</p>");
        out.println("</body></html>");
    }
}