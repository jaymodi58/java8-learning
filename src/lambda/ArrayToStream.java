package lambda;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayToStream {

	public static void main(String[] args) {

		int[] array = { 2, 23, 12, 9, 34, 6, 2, 14, 54, 23 };

		IntStream intStream = Arrays.stream(array);
		intStream.forEach(System.out::println);
	}

}
