import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import jakarta.servlet.*; // интерфейсы и классы общего типа 
import jakarta.servlet.http.*; // расширение javax.servlet для http
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bbb extends HttpServlet implements Servlet {
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String result = "";
        Enumeration headers = rq.getHeaderNames();
        Enumeration params = rq.getParameterNames();

        while (headers.hasMoreElements()) {
            String headerName = (String) headers.nextElement();
            if (headerName.contains("x")) {
                result += "\n" + headerName + ": " + rq.getHeader(headerName);
            }
        }
        result += "\n";

        while (params.hasMoreElements()) {
            String paramName = (String) params.nextElement();
            result += "\n" + paramName + ": " + rq.getParameter(paramName);
        }

        rs.addHeader("X-Response-1", "Response header 1");
        rs.addHeader("X-Response-2", "Response header 2");

        PrintWriter printWriter = rs.getWriter();
        printWriter.println(result);
    }
}
