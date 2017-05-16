package hello;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public GreetingWithTime greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime d = LocalDateTime.parse("2015/12/15 23:30:59", f);
        System.out.println(d.format(f));
        
        return new GreetingWithTime(counter.incrementAndGet(),
                            String.format(template, name),d.format(f));
    }
    
    @RequestMapping("/greeting2")
    public Greeting greeting2(@RequestParam(value="name", defaultValue="World") String name) {
    	
        
        this.validateUser(name);
        
        LocalDateTime ldate = LocalDateTime.of(2015, 12, 15, 23, 30, 59);
        
    	System.out.println("name is " + name);
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
    @RequestMapping(value="/user", method=RequestMethod.POST)
    public Greeting addUser(@RequestParam(value="name", defaultValue="World") String name) {
        this.validateUser(name);
        
        LocalDateTime ldate = LocalDateTime.of(2015, 12, 15, 23, 30, 59);
        
        //ここでステータスコード２０１を返したい
        System.out.println("ユーザ作成" + name);
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
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