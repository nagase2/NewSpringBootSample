package hello.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class CommonPartsInterfaceImpl 
implements CommonPartsInterface
{

    @Override
    public int sum(int a, int b) {
        return 0;
    }

    @Override
    public String getMessage() {
        return "this is return message from service impl";
    }
    

}
