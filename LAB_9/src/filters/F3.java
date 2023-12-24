package filters;

import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class F3 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("F3:init");
    }

    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain filterChain)
            throws IOException, ServletException {
        if (rq.getParameter("value3").equals("third")) {
            System.out.println("F3:doFilter");
            filterChain.doFilter(rq, rs);
        } else {
            PrintWriter out = rs.getWriter();
            out.println("F3 filter blocked");
        }
    }

    public void destroy() {
        System.out.println("F3:destroy");
    }
}
