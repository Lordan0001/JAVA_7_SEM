package jspclass;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Lastname extends TagSupport {
  String lastnameContent = "<label>Lastname</label>"
    + " <input name='lastname' type='text' width='130'"
    + " maxlength='20' ";
  public String value = "";

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public int doStartTag() throws JspException {
    JspWriter out = pageContext.getOut();
    try {
      out.print(lastnameContent + (this.value.equals("") ? "" : "value='" + this.value + "' />"));
    } catch (IOException e) {
      System.out.println("lastname: " + e);
    }
    return SKIP_BODY;
  }
}
