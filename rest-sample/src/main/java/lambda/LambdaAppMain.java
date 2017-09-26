package lambda;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;

public class LambdaAppMain {
	public static void main(String[] args) {
		
		LambdaCodeSample lmbSample = new LambdaCodeSample();
//		lmbSample.basicCode1();
//		lmbSample.streamApiSample();
//		lmbSample.mapAndStreamSample();
		lmbSample.collectionSample(); 
	}

}
