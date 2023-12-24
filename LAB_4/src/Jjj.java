import java.io.IOException; // исключения ввода/вывода 
import java.io.PrintWriter;

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

import java.util.Date;

public class Jjj extends HttpServlet implements Servlet {

    int hour = (new Date()).getHours();

    public Jjj() {
        super();
        System.out.println("Jjj:constructor");
    }

    public void init(ServletConfig sc) throws ServletException {
        // инициализация сервлета
        super.init();
        System.out.println("Jjj:init");
    }

    public void destroy() {
        // перед уничтожением сервлета
        super.destroy();
        System.out.println("Jjj:destroy");
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Jjj:doGet");
        HttpClient hc = new HttpClient();
        GetMethod gm;
        // task 8
        String uri = null;
        if (hour > 0 && hour <= 5) {
            uri = "http://localhost:8082/AS_BVD4/night.jsp";
        } else if (hour > 5 && hour < 12) {
            uri = "http://localhost:8082/AS_BVD4/morning.jsp";
        } else if (hour >= 12 && hour <= 17) {
            uri = "http://localhost:8082/AS_BVD4/afternoon.jsp";
        } else {
            uri = "http://localhost:8082/AS_BVD4/evening.jsp";
        }

        hc.executeMethod(gm = new GetMethod(uri));
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println(gm.getResponseBodyAsString());
        pw.flush();
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String getResponse = null;
        var httpClient = new HttpClient();
        String uri = null;
        if (hour > 0 && hour <= 5) {
            uri = "http://localhost:8082/AS_BVD4/night.jsp";
        } else if (hour > 5 && hour < 12) {
            uri = "http://localhost:8082/AS_BVD4/morning.jsp";
        } else if (hour >= 12 && hour <= 17) {
            uri = "http://localhost:8082/AS_BVD4/afternoon.jsp";
        } else {
            uri = "http://localhost:8082/AS_BVD4/evening.jsp";
        }
        HttpMethod hmethod = new PostMethod(uri);
        try {
            int statusCode = httpClient.executeMethod(hmethod);
            System.out.println(statusCode);
            if (statusCode == 200) {
                String responseBody = hmethod.getResponseBodyAsString();
                System.out.println(responseBody);
                getResponse = responseBody;
            } else {
                System.out.println("Request failed: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            hmethod.releaseConnection();
        }
        PrintWriter pw = rs.getWriter();
        pw.println(getResponse);
        pw.close();
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        if (rq.getMethod().contains("POST")) {
            this.doPost(rq, rs);
        } else if (rq.getMethod().contains("GET")) {
            this.doGet(rq, rs);
        }
    }
}
