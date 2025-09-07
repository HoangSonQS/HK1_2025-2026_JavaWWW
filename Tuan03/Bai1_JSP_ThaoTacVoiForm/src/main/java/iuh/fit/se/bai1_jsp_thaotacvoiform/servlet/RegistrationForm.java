package iuh.fit.se.bai1_jsp_thaotacvoiform.servlet;

import iuh.fit.se.bai1_jsp_thaotacvoiform.models.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {

    public RegistrationForm() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ Form
        String fname = request.getParameter("txtFName");
        String lname = request.getParameter("txtLName");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String email = request.getParameter("txtEmail");
        String mobileNumber = request.getParameter("txtMobileNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("txtAddress");
        String city = request.getParameter("txtCity");
        String pinCode = request.getParameter("txtPinCode");
        String state = request.getParameter("txtState");
        String country = request.getParameter("txtCountry");
        String hobbies = request.getParameter("chkHobbies");
        String course = request.getParameter("txtCourse");

        // Tạo đối tượng LocalDate từ ngày tháng năm
        LocalDate birthdate = null;
        if (day != null && month != null && year != null) {
            try {
                birthdate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            } catch (Exception e) {
            }
        }

        // Tạo đối tượng Student và gán dữ liệu
        Student student = new Student();
        student.setFirstName(fname);
        student.setLastName(lname);
        student.setEmail(email);
        student.setGender(gender);
        student.setBirthdate(birthdate);
        student.setMobileNumber(mobileNumber);
        student.setAddress(address);
        student.setCity(city);
        student.setPinCode(pinCode);
        student.setState(state);
        student.setCountry(country);
        student.setHobbies(hobbies);
        student.setCourse(course);


        // Lưu đối tượng Student vào request object
        request.setAttribute("student", student);

        // Chuyển tiếp tới trang result-form.jsp
        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);
    }
}