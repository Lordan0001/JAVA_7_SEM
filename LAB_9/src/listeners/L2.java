package listeners;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class L2 implements HttpSessionAttributeListener {
  public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
    System.out.println("Session attribute added");
  }

  public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
    System.out.println("Session attribute removed");
  }

  public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
    System.out.println("Session attribute replaced");
  }
}