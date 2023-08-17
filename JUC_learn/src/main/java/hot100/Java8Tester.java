package hot100;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Java8Tester {
	public static void main(String args[]){

		// 计算空字符串
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");


		System.out.println("使用 Java 8: ");
		System.out.println("列表: " +strings);

		long count = strings.stream().filter(string->string.isEmpty()).count();
		System.out.println("空字符串数量为: " + count);

		count = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("字符串长度为 3 的数量为: " + count);

		List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
		System.out.println("筛选后的列表: " + filtered);

		String mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("合并字符串: " + mergedString);

		List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);

		List<Integer>squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
		System.out.println("Squares List: " + squaresList);
		System.out.println("列表: " +integers);

		IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();

		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
		System.out.println("随机数: ");

		Random random = new Random();

		random.ints().limit(10).sorted().forEach(System.out::println);

		// 并行处理
		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("空字符串的数量为: " + count);
	}


}
