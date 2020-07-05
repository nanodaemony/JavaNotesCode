package javase.base.exception;

/**
 * 测试在Finally中return
 *
 * @author: nano
 * @time: 2020/6/29 10:55
 */
public class TestFinallyReturn {


	public static void main(String[] args) {

		System.out.println(f(3));;

	}

	public static int f(int n){
		try{
			int r = n * n;
			// 如果try子句含有return
			if (n == 3) {
				System.out.println("准备抛出异常");
				throw new RuntimeException();
			}
			return r;
		} catch (Exception e) {
			System.out.println("Exception");
			return 4;
		} finally{
			if (n == 3) {
				// finally中的return覆盖try中的return
				return 0;
			}
		}
	}

}
