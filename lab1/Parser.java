package lab1;

import java.io.File;
import java.util.HashMap;

interface Parser {
  
	public abstract void changeColor(String colorChoice);
	public abstract String parseFile(String filePath) throws Exception;
	public abstract void createHash(String shiftMe);
	public abstract HashMap<Integer,String[]> getHash();
	public abstract void lowerUpper(String caseSensitive);
	public abstract String getColor();
	public abstract boolean getCase();
	public abstract void setShift(int shiftAmount);
	public abstract int getShift();
	public abstract void print();
}
