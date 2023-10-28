import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class Sss extends HttpServlet {
    private static final Logger log = Logger.getLogger(Sss.class.getName());

    public Sss() {
        super();
        log.info("Sss:constructor");
    }

    public void init(ServletConfig sc) throws ServletException {
        super.init();
        log.info("Sss:init");
    }

    public void destroy() {
        super.destroy();
        log.info("Sss:destroy");
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        String remoteHost = rq.getServerName();
        String remoteAddr = rq.getRemoteAddr();

        pw.println("<html><body>"
                + "<br>Show remote changes"
                + "<br>doGet: FirstName = " + rq.getParameter("firstname")
                + "<br>doGet: LastName = " + rq.getParameter("lastname")
                + "<br>doGet: Host: " + remoteHost
                + "<br>doGet: IP Address: " + remoteAddr
                + "</body></html>");
        log.info("Sss:doGet - Request processed for " + rq.getParameter("firstname") + " " + rq.getParameter("lastname"));
        pw.close();
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        String remoteHost = rq.getServerName();
        String remoteAddr = rq.getRemoteAddr();
        pw.println("<html><body>"
                + "<br>doPost: firstname = " + rq.getParameter("firstname")
                + "<br>doPost: lastname = " + rq.getParameter("lastname")
                + "<br>doGet: Host: " + remoteHost
                + "<br>doGet: IP Address: " + remoteAddr
                + "</body></html>");
        log.info("Sss:doPost - Request processed for " + rq.getParameter("firstname") + " " + rq.getParameter("lastname"));
        pw.close();
    }
}
