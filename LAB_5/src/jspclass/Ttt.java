package jspclass;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ttt extends HttpServlet implements Servlet {
  public Ttt() {
    super();
  }

  public void init(ServletConfig config) throws ServletException {
    super.init();
  }

  public void destroy() {
    super.destroy();
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter printWriter = resp.getWriter();
    printWriter.println("Surname: "+req.getParameter("surname")
      + "  Name: " + req.getParameter("lastname")
      + "  Sex: " + req.getParameter("sex"));
  }
}
