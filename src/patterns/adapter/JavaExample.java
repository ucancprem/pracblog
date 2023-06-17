package patterns.adapter;

import java.util.Arrays;
import java.util.List;

public class JavaExample {
	public static void main(String[] args) {
		Integer[] intArr = {1, 34, 43};
		List<Integer> listOfInt = Arrays.asList(intArr);
		System.out.println(listOfInt);
	}
}
