package lab1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Parser fileReader=new Parse();
		String parsedFile=fileReader.parseFile("/root/Downloads/text.txt");
		Scanner input=new Scanner(System.in);
		
		System.out.println("Upper case or Lower case ? (U or L)");
		String caseSensitive=input.nextLine();
		fileReader.lowerUpper(caseSensitive);
		System.out.println("How many characters to shift ? (1-3)");
		int shiftAmount=input.nextInt();
		fileReader.setShift(shiftAmount);
		input.nextLine();
		System.out.println("Color of characters (R or Y)");
		String colorChoice=input.nextLine();
		fileReader.changeColor(colorChoice);
		
		fileReader.createHash(parsedFile);
		
		fileReader.print();
		
		input.close();
	}

}
