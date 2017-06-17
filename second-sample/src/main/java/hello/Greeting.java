package hello;

public class Greeting {

    private  long id=1;
    private  String content="second";

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
    public Greeting(){
    	
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    public String testMethod(){
    	return "abc";
    }
    public String testMethod2(){
    	return "111";
    }
}