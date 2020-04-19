package lab2;

public class CaseThread implements Runnable{
	private Parser parse;
	
	public CaseThread(Parser parse) {
		this.parse=parse;
	}
	@Override
	public void run() {
		parse.caseAllChar();	
	}
}
