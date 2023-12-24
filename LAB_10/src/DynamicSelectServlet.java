import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DynamicSelectServlet extends HttpServlet implements Servlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int param1 = Integer.parseInt(req.getParameter("param1"));


        String Url = "jdbc:mysql://localhost:3306/lab10";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Trying to connect");
            String user = "main";
            String password = "toor";
            Connection connection = DriverManager.getConnection(Url, user, password);
            System.out.println("Connection Established Successfull");

            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Students where id < ?");
            pstmt.setInt(1, param1);
            ResultSet rs = pstmt.executeQuery();

            PrintWriter out = resp.getWriter();
            while (rs.next()) {
                out.println(
                        "Id:" + rs.getString("Id") +
                                " Name:" + rs.getString("Name") +
                                " Phone:" + rs.getString("Phone"));
            }

        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }

}
