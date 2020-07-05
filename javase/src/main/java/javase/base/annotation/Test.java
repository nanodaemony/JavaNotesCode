package javase.base.annotation;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

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
