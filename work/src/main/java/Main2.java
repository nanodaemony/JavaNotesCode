import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: nano
 * @time: 2020/8/1 20:05
 */
public class Main2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();
		int[][] nums = new int[num][2];
		for (int i = 0; i < num; i++) {
			nums[i][0] = scanner.nextInt();
			nums[i][1] = scanner.nextInt();
		}
		// 按照发的顺序升序
		Arrays.sort(nums, Comparator.comparingInt(o -> o[1]));
//		System.out.println(Arrays.deepToString(nums));
		long max = 0;
		for(int i = 0; i < nums.length; i++) {
			max = Math.max(max, getMaxBonus(nums, i));
		}
		System.out.println(max);
	}

	private static int getMaxBonus(int[][] nums, int student) {
		int res = 0;
		int temp = 0;
		for (int i = student; i < nums.length; i++) {
			temp = temp + nums[i][0];
			res = Math.max(temp, res);
//			if (res > 1000000003) {
//				res = res % 1000000003;
//			}
		}
		return res;
	}

}
