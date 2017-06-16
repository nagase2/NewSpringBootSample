package hello;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import hello.exceptions.DontLikeTheNameException;
import hello.exceptions.UserNotFoundException;
import hello.service.CommonPartsInterface;

@RestController
public class GreetingController {
    
    @Inject
    private CommonPartsInterface xxx;
    
    @JsonFormat(pattern = "yyyyMMdd")
    LocalDateTime localdate;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    /**
     * 処理結果ステータスを指定して返す。
     * @param name
     * @return
     */
    @RequestMapping(value="/interface", method=RequestMethod.POST)
    public ResponseEntity interfaceTest(@RequestParam(value="name", defaultValue="World") String name) {
        System.err.println(xxx.getMessage());
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GreetingBean(counter.incrementAndGet(),
              String.format(template, name).toString()));
    }

    @RequestMapping("/greeting")
    public GreetingWithTime greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime d = LocalDateTime.parse("2015/12/15 23:30:59", f);
        System.out.println(d.format(f));
        Date dt = new Date(2017, 9, 10);
        
        return new GreetingWithTime(counter.incrementAndGet(),
                            String.format(template, name),d.format(f),dt);
    }
    
    @RequestMapping("/greeting2")
    public DateBean greeting2(@RequestParam(value="name", defaultValue="World") String name) {
        
        this.validateUser(name);
        localdate = LocalDateTime.of(2015, 12, 15, 23, 30, 59);
        
        DateBean db = new DateBean();
        db.setId(23);
        db.setLdt(LocalDateTime.of(2015, 12, 15, 23, 30, 59));
        db.setLd(LocalDate.now());
    	System.out.println("name is " + name);
    	return db;
    }
    
    
    /**
     * 処理結果ステータスを指定して返す。
     * @param name
     * @return
     */
    @RequestMapping(value="/user", method=RequestMethod.POST)
    public ResponseEntity addUser(@RequestParam(value="name", defaultValue="World") String name) {
        this.validateUser(name);
        
        LocalDateTime ldate = LocalDateTime.of(2015, 12, 15, 23, 30, 59);
        
        System.out.println("ユーザ作成  " + name);
      
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GreetingBean(counter.incrementAndGet(),
              String.format(template, name).toString()));
    }
    
    /**
     * ユーザ名を検証する。ユーザ―名によってExceptionを返す。
     * @param userId
     */
    private void validateUser(String userId) {
       if(userId.equals("new")){
           throw new UserNotFoundException(userId);
       }else if(userId.equals("old")){
           throw new DontLikeTheNameException(userId);
       }
    }
    
    @RequestMapping(value = "/order/{orderId}", method=RequestMethod.GET)
    public GreetingWithTime testPostPage2(@PathVariable String orderId) {
        System.out.println("sssssssss");
        //log.debug("REST controller has been called.");
        GreetingWithTime rb = new GreetingWithTime();
        rb.setContent(orderId);
        return rb;
    }
    @RequestMapping("test")
    public String testPostPage3() {
        System.out.println("xxxxxxx");
        //log.debug("REST controller has been called.");
        GreetingWithTime rb = new GreetingWithTime();
        return "xxxx";
    }
    
}