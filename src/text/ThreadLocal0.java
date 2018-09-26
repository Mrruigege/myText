package text;
//多线程 ThreadLocal是一个线程对象类，里面可以存其他对象，这样可以保证多线程不会覆盖，不同步的问题出现set.get.remove是对它里面其他类的操作
class Message{
	private String info;
	public Message() {}
	public void setinfo(String msg) {
		this.info = msg;
	}
	public String getMsg() {
		return info;
	}
}
class Chanel{
	private static final ThreadLocal<Message> THREADLOCAL = new ThreadLocal<Message>();
	private Chanel() {};
	public static void setMsg(Message msg) {
		THREADLOCAL.set(msg);
	}
	public static void send() {
		System.out.println(THREADLOCAL.get().getMsg() +"发送者：" +Thread.currentThread().getName());
	}
}
public class ThreadLocal0 {
	public static void main(String[] args) {
		new Thread(()->{
			Message msg = new Message();
			msg.setinfo("hello world");
			Chanel.setMsg(msg);
			Chanel.send();
		},"线程A").start();
		new Thread(()->{
			Message msg = new Message();
			msg.setinfo("hello world");
			Chanel.setMsg(msg);
			Chanel.send();
		},"线程B").start();
		new Thread(()->{
			Message msg = new Message();
			msg.setinfo("hello world");
			Chanel.setMsg(msg);
			Chanel.send();
		},"线程C").start();
	}
}
