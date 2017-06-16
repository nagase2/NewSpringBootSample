package hello.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RealCommonPartsInterface implements CommonPartsInterface {

    @Override
    public int sum(final int a, final int b) {
        return a + b;
    }

    @Override
    public String getMessage() {
        return this.getClass().getSimpleName();
    }
}
