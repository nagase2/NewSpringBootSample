package konichiwa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.Greeting;
import hello.HelloService;

@RequestMapping("/exp")
@RestController
public class ExperimentRestController {

		@Autowired
		private HelloService hService;
		
		  @RequestMapping("/simple")
		    public String simple(){
			  
			  
			  return "simple";
			  
		    }
}
