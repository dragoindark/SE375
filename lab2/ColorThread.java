package lab2;

public class ColorThread implements Runnable {
	private Parser parse;
	
	public ColorThread(Parser parse) {
		this.parse=parse;
	}
	@Override
	public void run() {
		parse.colorAllChar();
	}
}
