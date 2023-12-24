package filters;

import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class F2 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("F2:init");
    }

    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain filterChain)
            throws IOException, ServletException {
        try{
            Boolean chain = rq.getParameter("value2").equals("second");
            if (chain) {
                System.out.println("F2:doFilter");
                filterChain.doFilter(rq, rs);
            }
            else{
                throw new Exception();
            }
        }
        catch(Exception e)  {
            PrintWriter out = rs.getWriter();
            out.println("F2 filter blocked");
        }
    }

    public void destroy() {
        System.out.println("F2:destroy");
    }
}
