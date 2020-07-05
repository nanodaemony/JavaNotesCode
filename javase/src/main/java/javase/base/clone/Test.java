package javase.base.clone;

/**
 * @author: nano
 * @time: 2020/6/26 15:15
 */
public class Test {


	public static void main(String[] args) {


		CloneTest cloneTest= new CloneTest();
		try {
			CloneTest a = (CloneTest) cloneTest.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
