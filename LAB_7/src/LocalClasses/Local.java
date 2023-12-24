import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import jakarta.servlet.*; // интерфейсы и классы общего типа 
import jakarta.servlet.http.*; // расширение javax.servlet для http
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
      printWriter.println("There is no parameter");
    }
  }
}
