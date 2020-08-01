import java.util.HashMap;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/7/18 18:35
 */
public class Solution {


	public static void main(String[] args) {
		System.out.println("666");

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(2, 2);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if(entry.getKey() == 2) System.out.println("2");

		}
	}

}
