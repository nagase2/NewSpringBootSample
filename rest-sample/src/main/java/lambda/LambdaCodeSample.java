package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaCodeSample {
	private String totalStr = "";

	public void basicCode1() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("japan");
		stringList.add("usa");
		stringList.add("england");

		// 一秒の処理を書く場合（中括弧省略可能）
		stringList.forEach(xx -> System.out.println(xx));

		// 複数行の処理を書く場合
		stringList.forEach(xx -> {
			totalStr = totalStr + xx;
			System.out.println(totalStr);
		});
	}
	
	public void streamApiSample(){
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5,6,7,8,9);
		integerList.stream().filter(num-> num%2 == 0).forEach(num2 -> System.out.println(num2));
	}
}
