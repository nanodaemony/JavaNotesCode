package javase.reflect;

/**
 * @author: nano
 * @time: 2020/5/19 14:39
 */
public class User {

	private String name;

	public User() {
		name = "Tom";
	}

	public void publicMethod(String s) {
		System.out.println("I love " + s);
	}

	private void privateMethod() {
		System.out.println("Name is " + name);
	}
}