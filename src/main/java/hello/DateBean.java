package hello;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DateBean {
    private  long id;
    private  String content;
    private  LocalDateTime ldt;
    @JsonFormat(pattern = "yyyyMMdd")
    private  LocalDate ld;
    
    public DateBean(){}
    
    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;
    }

    public void setLd(LocalDate ld) {
        this.ld = ld;
    }

    public DateBean(long id, String content,LocalDateTime ldt, LocalDate ld) {
        this.id = id;
        this.content = content;
        this.ldt = ldt;
        this.ld = ld;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public LocalDate getLd() {
        return ld;
    }
}
