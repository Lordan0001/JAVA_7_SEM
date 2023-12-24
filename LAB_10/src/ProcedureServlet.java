import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProcedureServlet")
public class ProcedureServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "jdbc:mysql://localhost:3306/lab10";
        Connection connection = null;
        CallableStatement stmt = null;

        int id = Integer.parseInt(req.getParameter("param1"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Trying to connect");
            String user = "main";
            String password = "toor";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established Successfully");

            String storedProcedureCall = "{CALL InsertStudent(?, ?, ?)}";
            stmt = connection.prepareCall(storedProcedureCall);

            stmt.setInt(1, id);    // p_Id
            stmt.setString(2, name); // p_Name
            stmt.setString(3, phone); // p_Phone

            stmt.execute();

            // Получаем значение выходного параметра
            String status = stmt.getString(3);

            PrintWriter out = resp.getWriter();
            out.println(status);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
