package helpers;

import java.io.*;
import jakarta.servlet.*;

public class InOutServletHelper {
    public static void WriteToBuffer(ServletOutputStream servletOutputStream, InputStream inputStream)
            throws IOException {
        int buf;
        while ((buf = inputStream.read()) > 0) {
            servletOutputStream.write(buf);
        }

        servletOutputStream.flush();
    }
}