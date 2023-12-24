package jspclass;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Sex extends TagSupport {
  String sexContent = "<label>Sex</label>" +
    "<br/>" +
    "<input name='sex' type='radio' value='male' /> <label>Male</label>" +
    "<br/>" +
    "<input name='sex' type='radio' value='female' /> <label>Female</label>" + "<br/>" +
          "<input name='sex' type='radio' value='other' /> <label>Other</label>";

  public int doStartTag() throws JspException {
    JspWriter out = pageContext.getOut();
    try {
      out.print(sexContent);
    } catch (IOException e) {
      System.out.println("Sex: " + e);
    }
    return SKIP_BODY;
  }
}

