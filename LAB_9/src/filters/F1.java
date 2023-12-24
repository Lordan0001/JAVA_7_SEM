package filters;
import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class F1 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("F1:init");
    }

    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain filterChain)
            throws IOException, ServletException {
        if (rq.getParameter("value1").equals("first")) {
            System.out.println("F1:doFilter");
            filterChain.doFilter(rq, rs);
        } else {
            PrintWriter out = rs.getWriter();
            out.println("F1 filter blocked");
        }
    }

    public void destroy() {
        System.out.println("F1:destroy");
    }
}
