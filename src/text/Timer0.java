package text;
//定时器的用法
import java.util.Timer;
import java.util.TimerTask;
class MyTime extends TimerTask{  //timertask是一个抽象类，它的启动需要timer来开启
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "time : " + System.currentTimeMillis());
	}
}
public class Timer0 {
	public static void main(String[] args) {
		MyTime me = new MyTime();
		Timer t = new Timer();  //timer 启动timertask的任务
		t.scheduleAtFixedRate(me,100, 1000);//timertask，第一次启动的时间，每隔多久启动一次
//		t.schedule(me, 1000);
	}
}
