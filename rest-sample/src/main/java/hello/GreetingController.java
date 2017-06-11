package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	private HelloService hService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/greeting2")
    public Greeting greeting2(@RequestParam(value="name", defaultValue="World") String name) {
    	
    	System.out.println("aaa333qqqqwww3333");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/test")
    public Greeting test() {
    	
    	System.out.println("testです");
    	Greeting gre = new Greeting();
    	
    	Good g = new Good();
    	gre.setMessage(g.getValue1());
    	gre.setContent(hService.getMessage());
    	
    	
    	return gre ;
        //return new Greeting();
    }
}