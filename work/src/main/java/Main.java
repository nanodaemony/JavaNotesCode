import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/13 18:56
 */
public class Main {


	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();

		System.out.println(getNthNum(num));

	}


	private static long getNthNum(int num) {

		if(num <= 0 || num > 1000) return -1;

		long res = 0;
		long i = 0;
		while (true) {
			if(isValid(i)) {
				res++;
				if (res == num) return i;
			}
			i++;
		}
	}



	private static boolean isValid(long num) {
		char[] nums = ("" + num).toCharArray();

		for (char c : nums) {
			if (c != '2' && c != '3' && c != '5') return false;
		}
		return true;
	}
}
