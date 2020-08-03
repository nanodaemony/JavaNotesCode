import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: nano
 * @time: 2020/7/18 18:35
 */
public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] nums = new int[num];
		for (int i = 0; i < num; i++) {

//			nums[i] = scanner.nextInt();
			System.out.println(getCounter(scanner.nextInt()));
		}
	}

	private static int getCounter(int i) {
		int res = 0;
		while (i != 0) {
			res++;
			i = i / 2;
		}
		return res;
	}

}
