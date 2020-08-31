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


		String[] nums = new String[] {"1,1", "2,2", "1,2", "1,3"};
		System.out.println(get(nums));
	}

	public static int get(String[] points) {
		if(points == null || points.length == 0) {
			return -1;
		}
		int[][] nums = new int[points.length][2];
		for (int i = 0; i < nums.length; i++) {
			nums[i][0] = Integer.parseInt(points[i].split(",")[0]);
			nums[i][1] = Integer.parseInt(points[i].split(",")[1]);
		}
		int sumX = 0;
		int sumY = 0;
		for (int i = 0; i < nums.length; i++) {
			sumX = sumX + nums[i][0];
			sumY = sumY + nums[i][1];
		}
		double pivotX = (double) (sumX / nums.length);
		double pivotY = (double) (sumY / nums.length);
		int res = 0;
		double distance = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			double temp = Math.pow((nums[i][0] - pivotX), 2) + Math.pow((nums[i][1] - pivotY), 2);
			if(temp < distance) {
				distance = temp;
				res = i;
			}
		}
		return res;
	}

}
