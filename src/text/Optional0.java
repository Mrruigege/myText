package text;

import java.util.Optional;

class MessageUtil{
	private MessageUtil() {}
	public static Optional<MessageImpl> getMessage() {
		return Optional.ofNullable(null);
	}
	public static void useMessage(MessageImpl msg) {
		System.out.println(msg.Connect());
	}
}
interface IMessage{
	public String Connect();
}
class MessageImpl implements IMessage{
	@Override
	public String Connect() {
		return "www.cctv.com";
	}
}
public class Optional0 {
	public static void main(String[] args) {
		MessageImpl msg = MessageUtil.getMessage().orElse(new MessageImpl());
		MessageUtil.useMessage(msg);
	}
}
