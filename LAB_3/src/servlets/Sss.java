import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.PrintWriter;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import helpers.*;

public class Sss extends HttpServlet implements Servlet {

    public Sss() {
        super();
        System.out.println("Sss:constructor");
    }

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init();
        System.out.println("Sss:init");
    }

    public void destroy() {
        super.destroy();
        System.out.println("Sss:destroy");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Sss:service:" + request.getMethod());
//2
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        if (request.getMethod().equalsIgnoreCase("POST") && servletPath == "/Sss/forward") {
            System.out.println("Sss:doPost:forward:Ggg");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Ggg");
            requestDispatcher.forward(request, response);
            return;
        }
        if (request.getMethod().equalsIgnoreCase("POST") && servletPath == "/Sss/redirect") {
            System.out.println("Sss:doPost:redirect:Ggg");

            String path = request.getContextPath() + "/Ggg";
            response.setStatus(307);
            response.setHeader("Location", path);
            return;
        }

        super.service(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        RequestDispatcher requestDispatcher = null;
        String userName = request.getParameter("userName");
        String userId = request.getParameter("userId");
        String params = "userName=" + userName + "&" + "userId=" + userId;
        PrintWriter out;
        String path="";
        System.out.println(servletPath);
        switch (servletPath) {
            case "/Sss/htmlForward"://3
                System.out.println("Sss:doGet:forward:html");

                requestDispatcher = request.getRequestDispatcher("/main.html");
                requestDispatcher.forward(request, response);
                break;
            case "/Sss/doubleForward":
                System.out.println("Sss:doGet:doubleForward");
                out = response.getWriter();
                out.println(HtmlHelper.generateHtmlPage("<h1>Sss:doubleForward:</h1>"));
                requestDispatcher = request.getRequestDispatcher("/Ggg/doubleForward");
                requestDispatcher.forward(request, response);
                break;
            case "/Sss/servletForward":
                out = response.getWriter();
                System.out.println("Sss:doGet:forward:Ggg");
                out.println(HtmlHelper.generateHtmlPage("<h1>Ssss:doGet:forward:Ggg:</h1>"));
                requestDispatcher = request.getRequestDispatcher("/Ggg?" + params);
                requestDispatcher.forward(request, response);
                break;
            case "/Sss/servletRedirect":
                System.out.println("Sss:doGet:redirect:Ggg");


                path = request.getContextPath() + "/Ggg?" + params;
                response.sendRedirect(path);
                break;
            case "/Sss/htmlRedirect":
                System.out.println("Sss:doGet:redirect:html");

                path = request.getContextPath() + "/main.html";
                response.sendRedirect(path);
                break;
            case "/Sss/doubleRedirect":
                System.out.println("Sss:doGet:doubleRedirect");
                path = request.getContextPath() + "/Ggg/doubleRedirect";
                response.sendRedirect(path);
                break;
            case "/Sss/httpClient":
                System.out.println("Sss:doGet:HttpClient:Ggg");
                path = request.getContextPath() + "/Ggg/httpClientResponse?message=hello";

                HttpClient httpClient = new HttpClient();
                GetMethod getMethod = new GetMethod("http://localhost:8082" + path);
                httpClient.executeMethod(getMethod);

                if (getMethod.getStatusCode() == HttpStatus.SC_OK) {
                    InOutServletHelper.WriteToBuffer(response.getOutputStream(), getMethod.getResponseBodyAsStream());
                } else {
                    System.out.println("Sss:doGet:HttpClient:Error:statuscode: " + getMethod.getStatusCode());
                }
                break;
            case "/Sss/PosthttpClient":
                System.out.println("Sss:doPost:с:Ggg");

                HttpClient hc = new HttpClient();
                PostMethod pm = new PostMethod("http://localhost:8082"
                        + request.getContextPath() + "/Ggg");
                NameValuePair[] parms = {new NameValuePair("firstname", "Some"),
                        new NameValuePair("lastname", "name"),
                        new NameValuePair("age", "22")};
                pm.addParameters(parms);
                hc.executeMethod(pm);
                if (pm.getStatusCode() == HttpStatus.SC_OK) {
                    InOutServletHelper.WriteToBuffer(response.getOutputStream(), pm.getResponseBodyAsStream());
                } else {
                    System.out.println("Sss:doGet:HttpClient:Error:statuscode: " + pm.getStatusCode());
                }
                break;
            case "/Sss/remoteHttpClient":
                System.out.println("Sss:doGet:HttpClient:Ggg");
                path = request.getContextPath() + "/Ggg/httpClientResponse?message=hello";

                HttpClient httpClient2 = new HttpClient();
                GetMethod getMethod2 = new GetMethod("http://192.168.68.128:8080" + path);
                httpClient2.executeMethod(getMethod2);

                if (getMethod2.getStatusCode() == HttpStatus.SC_OK) {
                    InOutServletHelper.WriteToBuffer(response.getOutputStream(), getMethod2.getResponseBodyAsStream());
                } else {
                    System.out.println("Sss:doGet:HttpClient:Error:statuscode: " + getMethod2.getStatusCode());
                }
                break;
            case "/Sss/remotePostHttpClient":
                System.out.println("Sss:doPost:с:Ggg");

                HttpClient hc2 = new HttpClient();
                PostMethod pm2 = new PostMethod("http://192.168.68.128:8080"
                        + request.getContextPath() + "/Ggg");
                NameValuePair[] parms2 = {new NameValuePair("firstname", "Some"),
                        new NameValuePair("lastname", "name"),
                        new NameValuePair("age", "22")};
                pm2.addParameters(parms2);
                hc2.executeMethod(pm2);
                if (pm2.getStatusCode() == HttpStatus.SC_OK) {
                    InOutServletHelper.WriteToBuffer(response.getOutputStream(), pm2.getResponseBodyAsStream());
                } else {
                    System.out.println("Sss:doGet:HttpClient:Error:statuscode: " + pm2.getStatusCode());
                }
                break;
        }
    }
}