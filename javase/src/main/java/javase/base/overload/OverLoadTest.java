package javase.base.overload;

/**
 * 重载方法
 *
 * @author: nano
 * @time: 2020/6/25 15:29
 */
public class OverLoadTest {


	public void test(String name, String age) {}

	// public void test(String age, String name) {} // 不合法

	public void test(String age, Integer name) {}

	public void test(Integer age, String name) {}

//	public int test(Integer age, String name) {}	// 不合法

}
