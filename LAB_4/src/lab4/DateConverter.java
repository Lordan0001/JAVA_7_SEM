package lab4;
import java.util.*;

public class DateConverter {
    protected String R = null;
    Calendar C;
    protected Date d = new Date();

    public DateConverter(Calendar c) {
        this.C = c;
    }

    public DateConverter() {
        this.C = Calendar.getInstance();
    }

    public Integer GetHOUR() {
        return ((Integer) C.get(Calendar.HOUR_OF_DAY));
    }
}