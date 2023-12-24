import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import jakarta.servlet.*; // интерфейсы и классы общего типа 
import jakarta.servlet.http.*; // расширение javax.servlet для http
import java.io.IOException;
import java.io.PrintWriter;

public class Aaa extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        HttpClient hc = new HttpClient();
        String uri = "http://192.168.68.128:8080/AS_BVD8/Bbb";

        PostMethod postMethod = new PostMethod(uri);

        postMethod.addRequestHeader("X-Request-1", "1");
        postMethod.addRequestHeader("X-Request-2", "2");
        postMethod.addRequestHeader("X-Request-3", "3");
        postMethod.addParameter("X-Request-1", "1");
        postMethod.addParameter("X-Request-2", "2");
        postMethod.addParameter("X-Request-3", "3");

        hc.executeMethod(postMethod);

        PrintWriter printWriter = rs.getWriter();
        printWriter.println(postMethod.getResponseBodyAsString());
        printWriter.println("All Headers: ");

        Header[] headers = postMethod.getResponseHeaders();

        for (Header header : headers)
            printWriter.println(header.getName() + ": " + header.getValue());
    }
}
