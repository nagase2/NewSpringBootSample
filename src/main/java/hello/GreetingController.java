package hello;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;
import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.exceptions.DontLikeTheNameException;
import hello.exceptions.UserNotFoundException;
import service.CommonPartsInterface;

@RestController
public class GreetingController {
    
    @Inject
    private CommonPartsInterface test;


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    /**
     * 処理結果ステータスを指定して返す。
     * @param name
     * @return
     */
    @RequestMapping(value="/interface", method=RequestMethod.POST)
    public ResponseEntity interfaceTest(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("★"+test.getMessage());
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Greeting(counter.incrementAndGet(),
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
    public Greeting greeting2(@RequestParam(value="name", defaultValue="World") String name) {
    	
        
        this.validateUser(name);
        
        LocalDateTime ldate = LocalDateTime.of(2015, 12, 15, 23, 30, 59);
        
    	System.out.println("name is " + name);
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
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
      
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Greeting(counter.incrementAndGet(),
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
    
}