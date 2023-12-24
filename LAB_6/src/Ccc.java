import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypackage.CBean;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


public class Ccc extends HttpServlet implements Servlet {
  public void init() throws ServletException {
    super.init();
    getServletContext().setAttribute("atrCBean", new CBean());
  }

  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = rq.getRequestDispatcher("/Ccc.jsp");
    requestDispatcher.forward(rq, rs);
  }

  protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    String value1 = rq.getParameter("value1");
    String value2 = rq.getParameter("value2");
    String value3 = rq.getParameter("value3");
    String cbean = rq.getParameter("cbean");

    if (cbean.equals("new")) {
      getServletContext().setAttribute("atrCBean", new CBean());
    }

    setValues(value1, value2, value3);

    RequestDispatcher requestDispatcher = rq.getRequestDispatcher("/Ccc.jsp");
    requestDispatcher.forward(rq, rs);
  }

  private void setValues(String value1, String value2, String value3) {
    CBean ob = (CBean) getServletContext().getAttribute("atrCBean");

    if (value1 != "") {
      ob.setValue1(value1);
    }

    if (value2 != "") {
      ob.setValue2(value2);
    }

    if (value3 != "") {
      ob.setValue3(value3);
    }
  }
}

