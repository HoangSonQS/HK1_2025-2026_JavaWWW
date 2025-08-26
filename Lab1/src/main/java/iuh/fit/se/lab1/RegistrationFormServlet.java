package iuh.fit.se.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/registrationForm")
public class RegistrationFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username  = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String[] skills = req.getParameterValues("skills");
        String shortBio = req.getParameter("shortBio");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #333; color: #fff; padding: 20px; }");
        out.println("h2 { color: #007bff; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Registration Details</h2>");
        out.println("<p><strong>Name:</strong> " + firstName + " " + lastName + "</p>");
        out.println("<p><strong>Username:</strong> " + username  + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Gender:</strong> " + gender + "</p>");
        out.println("<p><strong>Skills:</strong> " + (skills != null ? Arrays.toString(skills) : "None") + "</p>");
        out.println("<p><strong>Short Bio:</strong> " + shortBio + "</p>");

        out.println("<h3>HTTP Method: " + req.getMethod() + "</h3>");
        if ("GET".equalsIgnoreCase(req.getMethod())) {
            out.println("<p>Dữ liệu được gửi qua URL Query String. Rất dễ thấy trên thanh địa chỉ của trình duyệt.</p>");
        } else if ("POST".equalsIgnoreCase(req.getMethod())) {
            out.println("<p>Dữ liệu được gửi trong phần body của request và không hiển thị trên URL.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
