package jspclass;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Submit extends TagSupport {
  //String submitContent = "<input type='submit' value='ok' />" + " <input type='button' value='close' />";
  String submitContent = "<input type='submit' value='ok' />";
  public int doStartTag() throws JspException {
    JspWriter out = pageContext.getOut();
    try {
      out.print(submitContent);
    } catch (IOException e) {
      System.out.println("Submit:" + e);
    }
    return SKIP_BODY;
  }
}