package hello;

public class Greeting {

    private  long id=1;
    private  String content="third";

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
}