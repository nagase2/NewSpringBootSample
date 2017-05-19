package hello;

import java.time.LocalDateTime;
import java.util.Date;

public class GreetingWithTime {

    private  long id;
    private  String content;
    private  String ldate;
    private  Date dat;

    public GreetingWithTime(long id, String content,String ldate,Date dat) {
        this.id = id;
        this.content = content;
        this.ldate = ldate;
        this.dat = dat;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    public String getLdate() {
        return ldate;
    }
    public Date getDat() {
        return dat;
    }
}