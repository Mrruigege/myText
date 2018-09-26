package text;
//加密解密处理
import java.util.Base64;
class Encode{
	private static final String SALT = "cctv";  //盐值
	private static final int REPEAT = 10;       //加密次数
	public static String encode(String str) {
		String temp = str + "{" + SALT + "}";
		byte [] date = str.getBytes();
		for (int x = 0 ; x < REPEAT ; x ++) {
			date = Base64.getEncoder().encode(temp.getBytes());//加密处理
		}
		return new String(date);
	}
	public static String decode(String str) {
		byte date[] = str.getBytes();
		for(int x = 0 ; x < REPEAT ; x ++) {
			date = Base64.getDecoder().decode(str); // 解密处理
		}
		return new String(date).replaceAll("\\{\\w+\\}", "");
	}
}
public class Base640 {
	public static void main(String[] args) {
		String str = "www.cctv.cn";
		String enc = Encode.encode(str);
		String dec = Encode.decode(enc);
		System.out.println(enc);
		System.out.println(dec);
	}
}
