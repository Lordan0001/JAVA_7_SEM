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
    HttpSession session = rq.getSession();
    String sessionId = session.getId();
    CBean cbeanSession = (CBean) session.getAttribute(sessionId);
    CBean objForSession = new CBean();
    CBean objForRequest = new CBean();
    String value1 = rq.getParameter("value1");
    String value2 = rq.getParameter("value2");
    String value3 = rq.getParameter("value3");
    String cbean = rq.getParameter("cbean");

    if (cbeanSession != null) {
      objForSession = cbeanSession;
    } else {
      session.setAttribute(sessionId, objForSession);
      session.setMaxInactiveInterval(10);
    }

    if (cbean != null && cbean.equals("new")) {
      rq.setAttribute("atrCBean", new CBean());
      session.removeAttribute(sessionId);
      session.setAttribute(sessionId, new CBean());
    }

    setValues(objForSession, objForRequest, value1, value2, value3);

    session.setAttribute(sessionId, objForSession);
    rq.setAttribute("atrCBean", objForRequest);

    RequestDispatcher requestDispatcher = rq.getRequestDispatcher("/Ccc.jsp");
    requestDispatcher.forward(rq, rs);
  }

  private void setValues(CBean objForSession, CBean objForRequest, String value1, String value2, String value3) {
    if (value1 != "") {
      objForSession.setValue1(value1);
      objForRequest.setValue1(value1);
    }

    if (value2 != "") {
      objForSession.setValue2(value2);
      objForRequest.setValue2(value2);
    }

    if (value3 != "") {
      objForSession.setValue3(value3);
      objForRequest.setValue3(value3);
    }
  }
}

