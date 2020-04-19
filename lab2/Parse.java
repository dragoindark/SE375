package lab2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Parse implements Parser {
	private String colorChoice;
	private boolean caseSensitive;
	private int shiftAmount;
	private HashMap<Integer, String[]> newHash = new HashMap<Integer, String[]>();
	char[] buffer;
	String[] bufferCase;
	String[] bufferShift;
	String[] bufferColor;

	@Override
	public void changeColor(String colorChoice) {
		if (colorChoice.equalsIgnoreCase("y")) {
			this.colorChoice = "\u001B[33m";
		} else if (colorChoice.equalsIgnoreCase("r")) {
			this.colorChoice = "\u001B[31m";
		} else {
			System.out.println("Choose between red or yellow");
		}
	}

	@Override
	public String parseFile(String filePath) throws Exception {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(filePath)));
		return data;
	}

	@Override
	public void lowerUpper(String caseSensitive) {
		if (caseSensitive.equalsIgnoreCase("l")) {
			this.caseSensitive = true;
		} else if (caseSensitive.equalsIgnoreCase("u")) {
			this.caseSensitive = false;
		} else {
			System.out.println("Choose Upper or Lower");
		}
	}

	@Override
	public String getColor() {
		return colorChoice;
	}

	@Override
	public boolean getCase() {
		return caseSensitive;
	}

	@Override
	public void setShift(int shiftAmount) {
		this.shiftAmount = shiftAmount;

	}

	@Override
	public int getShift() {
		return shiftAmount;
	}

	public void createThreadedHash() {
		for(int i=0;i<buffer.length;i++) {
			String[] hashArray=new String[4];
			hashArray[0]=String.valueOf(buffer[i]);
			hashArray[1]=bufferCase[i];
			hashArray[2]=bufferShift[i];
			hashArray[3]=bufferColor[i];
			newHash.put(i,hashArray);
		}
	}

	public void parsedChars(String shiftMe) {
		shiftMe.replace(" ", "");
		shiftMe.replace(".", "");
		buffer = shiftMe.toCharArray();
		bufferCase=new String[buffer.length];
		bufferShift=new String[buffer.length];
		bufferColor=new String[buffer.length];
	}
    
	public void shiftAllChar() {
		for(int i=0;i<buffer.length;i++) {
			bufferShift[i]=String.valueOf(shiftChar(buffer[i]));
		}
	}
	
	public void caseAllChar() {
		for(int i=0;i<buffer.length;i++) {
			bufferCase[i]=upperLower(buffer[i]);
		}
	}
	public void colorAllChar() {
		for(int i=0;i<buffer.length;i++) {
			bufferColor[i]=colorChanger(buffer[i]);
		}
	}
	
	
	
	public char shiftChar(char letter) {
		letter = (char) (letter + getShift());
		if (letter > 'z' || letter > 'Z') {
			letter = (char) (letter - 26);
		} else if (letter < 'a' || letter > 'A') {
			letter = (char) (letter + 26);
		}
		return letter;
	}

	public String upperLower(char letters) {
		String letter=String.valueOf(letters);
		if (getCase()) {
			letter = letter.toLowerCase();
		} else {
			letter = letter.toUpperCase();
		}
		return letter;
	}

	public String colorChanger(char afterCases) {
		String afterCase=String.valueOf(afterCases);
		return new String(getColor() + afterCase + "\u001B[0m");
	}

	@Override
	public HashMap<Integer, String[]> getHash() {
		return newHash;
	}

	@Override
	public void print() {
		String original = "";
		String afterCase = "";
		String afterShift = "";
		String afterColor="";
		for (String[] i : getHash().values()) {
			original += i[0];
			afterCase += i[1];
			afterShift += i[2];
			afterColor+=i[3];
		}
		System.out.println(original);
		System.out.println(afterCase);
		System.out.println(afterShift);
		System.out.println(afterColor);

	}

}
