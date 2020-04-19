package lab1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Parse implements Parser {
    private String colorChoice;
    private boolean caseSensitive;
    private int shiftAmount;
    private HashMap<Integer,String[]> newHash = new HashMap<Integer,String[]>();
	@Override
	public void changeColor(String colorChoice) {
		if(colorChoice.equalsIgnoreCase("y")) {
			this.colorChoice="\u001B[33m";
		}else if (colorChoice.equalsIgnoreCase("r")) {
			this.colorChoice="\u001B[31m";
		}else {
			System.out.println("Choose between red or yellow");
		}
	}

	@Override
	public String parseFile(String filePath) throws Exception {
		String data="";
		data=new String(Files.readAllBytes(Paths.get(filePath)));
		return data;		
	}

	@Override
	public void lowerUpper(String caseSensitive) {
		if(caseSensitive.equalsIgnoreCase("l")) {
			this.caseSensitive=true;
		}else if (caseSensitive.equalsIgnoreCase("u")) {
			this.caseSensitive=false;
		}else {
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
		this.shiftAmount=shiftAmount;
		
	}

	@Override
	public int getShift() {
		return shiftAmount;
	}

	@Override
	public void createHash(String shiftMe) {
    shiftMe.replace(" ","");
    shiftMe.replace(".","");
    char[] buffer=shiftMe.toCharArray();
    for(int i=0;i<buffer.length;i++) {
    	char letter=buffer[i];
    	String[] hashArray=new String[4];
    	hashArray[0]=String.valueOf(letter);
    	letter=(char) (letter+getShift());
    	if(letter>'z' || letter>'Z') {
    		letter=(char) (letter-26);	
    	}else if(letter<'a'|| letter>'A') {
    		letter=(char) (letter+26);
    	}
    	if(getCase()) {
    		hashArray[1]=hashArray[0].toLowerCase();
    	}else {
    		hashArray[1]=hashArray[0].toUpperCase();
    	}
    	hashArray[2]=String.valueOf(letter);
    	hashArray[3]=getColor();
    	newHash.put(i,hashArray);
    }
		
	}

	@Override
	public HashMap<Integer, String[]> getHash() {
		return newHash;
	}

	@Override
	public void print() {
		String original="";
		String afterCase="";
		String afterShift="";
		for (String[] i : getHash().values()) {
			  original+=i[0];
			  afterCase+=i[1];
			  afterShift+=i[2];
			}
		String afterColor=new String(getColor()+afterCase+"\u001B[0m");
		System.out.println(original);
		System.out.println(afterCase);
		System.out.println(afterShift);
		System.out.println(afterColor);
		
	}

}
