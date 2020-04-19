package lab2;

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
		
		fileReader.parsedChars(parsedFile);
		
		Thread caseThread=new Thread(new CaseThread(fileReader));
		Thread shiftThread=new Thread(new ShiftThread(fileReader));
		Thread colorThread=new Thread(new ColorThread(fileReader));
		
		caseThread.start();
		caseThread.join();
		shiftThread.start();
		shiftThread.join();
		colorThread.start();
		colorThread.join();
		
		fileReader.createThreadedHash();
		fileReader.print();
		
		input.close();
	}

}
