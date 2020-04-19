package lab2;

public class ShiftThread implements Runnable{
    private Parser parse;
	
	public ShiftThread(Parser parse) {
		this.parse=parse;
	}
	@Override
	public void run() {
		parse.shiftAllChar();	
	}

}
