package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ch.qos.logback.core.net.SyslogOutputStream;

public class LambdaCodeSample {
	private String totalStr = "";

	public void basicCode1() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("japan");
		stringList.add("usa");
		stringList.add("england");

		// 一行の処理を書く場合（中括弧省略可能）
		stringList.forEach(xx -> System.out.println(xx));

		// 複数行の処理を書く場合
		stringList.forEach(xx -> {
			totalStr = totalStr + xx;
			System.out.println(totalStr);
		});
	}

	/**
	 * streamとforeach
	 */
	public void streamApiSample() {
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		integerList.stream().filter(num -> num % 2 == 0 || num % 3 == 0).forEach(num2 -> {
			System.out.println("first" + num2);
		});

		List<Integer> integerLis2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		integerList.stream().filter(num -> num % 2 == 0).forEach(num2 -> {
			System.out.println("second" + num2);
		});
	}

	/**
	 * マップ＋ストリーム＋ラムダを使ったサンプルプログラム
	 */
	public void mapAndStreamSample() {
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		numMap.put(1, 0);
		numMap.put(2, 5);
		numMap.put(3, 6);
		numMap.put(4, 7);
		numMap.put(5, 8);
		//ストリーム使ってフィルタを掛ける
		numMap.entrySet().stream().filter(xx -> xx.getValue().intValue() > 5)
				.forEach(a -> System.out.println(a.getKey()));
		
		System.out.println("-----------処理２----------");
		//全部の値を対象に処理をする
		numMap.forEach((key,value)->{
			System.out.println("key="+key+" value=" + value);
		});
	}
	
	/**
	 * フィルターで条件を指定して、それにマッチするものだけを抽出する。
	 */
	public void collectionSample() {
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		int summedValue = integerList.stream().mapToInt(Integer::intValue).sum();
		System.out.println("合計値："+summedValue);
		
		List<Integer> filteredList = integerList.stream().filter(num-> num>5).collect(Collectors.toList());
		System.out.println(filteredList);
		
	}
	
}
