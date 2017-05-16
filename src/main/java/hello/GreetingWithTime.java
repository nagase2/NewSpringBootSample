package hello;

import java.time.LocalDateTime;

public class GreetingWithTime {

    private final long id;
    private final String content;
    private final String ldate;

    public GreetingWithTime(long id, String content,String ldate) {
        this.id = id;
        this.content = content;
        this.ldate = ldate;
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
}