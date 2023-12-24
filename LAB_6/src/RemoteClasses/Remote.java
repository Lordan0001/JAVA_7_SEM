package RemoteClasses;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Remote extends HttpServlet implements Servlet {
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    PrintWriter printWriter = rs.getWriter();
    printWriter.println("<h1>Remote servlet</h1>");
  }
}
