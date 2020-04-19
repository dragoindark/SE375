package lab2;

import java.util.HashMap;

interface Parser {
  
	public abstract void changeColor(String colorChoice);
	public abstract String parseFile(String filePath) throws Exception;
	public abstract void createThreadedHash();
	public abstract HashMap<Integer,String[]> getHash();
	public abstract void lowerUpper(String caseSensitive);
	public abstract String getColor();
	public abstract boolean getCase();
	public abstract void setShift(int shiftAmount);
	public abstract int getShift();
	public abstract void print();
	public abstract void parsedChars(String shiftMe);
	public abstract void shiftAllChar();
	public abstract void caseAllChar();
	public abstract void colorAllChar();
}
