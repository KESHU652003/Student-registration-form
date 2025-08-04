import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String dob = request.getParameter("dob");
    String gender = request.getParameter("gender");
    String course = request.getParameter("course");

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studentdb", "root", "password");

      String query = "INSERT INTO students(name, email, phone, dob, gender, course) VALUES (?, ?, ?, ?, ?, ?)";
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setString(1, name);
      stmt.setString(2, email);
      stmt.setString(3, phone);
      stmt.setString(4, dob);
      stmt.setString(5, gender);
      stmt.setString(6, course);

      int rows = stmt.executeUpdate();
      if (rows > 0) {
        out.println("<h3>Registration Successful!</h3>");
      } else {
        out.println("<h3>Error in registration</h3>");
      }

      conn.close();
    } catch (Exception e) {
      out.println("<h3>Error: " + e.getMessage() + "</h3>");
    }
  }
}
