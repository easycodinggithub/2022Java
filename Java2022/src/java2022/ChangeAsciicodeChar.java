package java2022;

import java.util.Scanner;

public class ChangeAsciicodeChar {
private Scanner scanner;
	
	public void prepareScanner() {
		this.scanner = new Scanner(System.in);
	}
	
	public void closeScanner() {
		this.scanner.close();
	}
	
	public Scanner getScanner() {
		return this.scanner;
	}
	
	public static void main(String[] args) {
		ScannerStudy study = new ScannerStudy();
		study.prepareScanner();
		
		Scanner scanner = study.getScanner();
		
		while (true) {
			System.out.print("Write some ASCII code to convert char : ");
			
			int intValue = scanner.nextInt();
			
			if (intValue == -1) {
				System.out.println("Goodbye!");
				break;
			}
			
			System.out.printf("%d ASCII code is %c \n", intValue, intValue);
		}
		
		study.closeScanner();
	}
}
