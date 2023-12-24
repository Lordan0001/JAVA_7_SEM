package LocalClasses;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.io.PrintWriter;

public class Local extends HttpServlet implements Servlet {
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    HttpClient hc = new HttpClient();
    PrintWriter printWriter = rs.getWriter();
    String urlN = rq.getParameter("urln");
    ServletContext sc = getServletContext();
    String uri = sc.getInitParameter("URL" + urlN);

    if (uri != null) {
      GetMethod gm = new GetMethod(uri);
      hc.executeMethod(gm);
      printWriter.println(gm.getResponseBodyAsString());
    } else {
      printWriter.println("parameter URL"+urlN +" not found");
    }
  }
}
