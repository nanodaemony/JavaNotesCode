package javase.annotation;

import java.lang.reflect.Method;

/**
 * @author: nano
 * @time: 2020/5/19 15:15
 */
public class Test {


	private String name;

	@FruitName("Apple")
	public String getName() {
		return name;
	}

	public static void main(String[] args) throws NoSuchMethodException {
		Class classTest = Test.class;
		Method method = classTest.getMethod("getName");
		FruitName fruitName = method.getAnnotation(FruitName.class);
		System.out.println(fruitName.value());
	}
}
