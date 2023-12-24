import java.io.IOException; // исключения ввода/вывода 
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.*; // интерфейсы и классы общего типа 
import jakarta.servlet.http.*; // расширение javax.servlet для http

public class Afternoon extends HttpServlet implements Servlet {
    public Afternoon() {
        super();
        System.out.println("Afternoon:constructor");
    }

    public void init(ServletConfig sc) throws ServletException {
        // инициализация сервлета
        super.init();
        System.out.println("Afternoon:init");
    }

    public void destroy() {
        // перед уничтожением сервлета
        super.destroy();
        System.out.println("Afternoon:destroy");
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
            PrintWriter printWriter = rs.getWriter();

            printWriter.println("Servlet:Good afternoon");
    }
}
