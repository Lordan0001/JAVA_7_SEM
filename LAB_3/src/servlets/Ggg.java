import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.PrintWriter;

import helpers.*;

public class Ggg extends HttpServlet implements Servlet {

    public Ggg() {
        super();
        System.out.println("Ggg:constructor");
    }

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init();
        System.out.println("Ggg:init");
    }

    public void destroy() {
        super.destroy();
        System.out.println("Ggg:destroy");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Ggg:service:" + request.getMethod());
        super.service(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        RequestDispatcher requestDispatcher = null;
        PrintWriter out = response.getWriter();
        switch (servletPath) {
            case "/Ggg/doubleForward":
                System.out.println("Ggg:doGet:forward:html");
                out.println(HtmlHelper.generateHtmlPage("<h1>Ggg:doubleForward:</h1>"));

                requestDispatcher = request.getRequestDispatcher("/main.html");
                requestDispatcher.forward(request, response);
                break;
            case "/Ggg/doubleRedirect":
                System.out.println("Ggg:doGet:redirect:html");

                String path = request.getContextPath() + "/main.html";
                response.sendRedirect(path);
                break;
            case "/Ggg/httpClientResponse":
                System.out.println("Ggg:doGet:handleHttpClient");

                String message = request.getParameter("message");

                response.setContentType("text/html");

                out.println(HtmlHelper.generateHtmlPage("<h1>Ggg:HttpClient:message " + message + "</h1>"));
                out.flush();
                break;
            default:
                System.out.println("Ggg:doGet");

                String userName = request.getParameter("userName");
                String userId = request.getParameter("userId");
                String params = "userName=" + userName + "&" + "userId=" + userId;

                response.setContentType("text/html");

                out.println(HtmlHelper.generateHtmlPage("<h1>Ggg:doGet: " + params + "</h1>"));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Ggg:doPost");

        response.setContentType("text/html");

        String params = request.getParameter("age");

        PrintWriter out = response.getWriter();
        out.println(HtmlHelper.generateHtmlPage("<h1>Ggg:doPost: " + params + "</h1>"));
    }

}