package java2022;

import java.util.Scanner;

import kr.hs.dgsw.java.dept23.d0317.ScannerStudy;

public class ScannerDog {
	
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
		
		public static void sayHello(String dn) {
			System.out.println("Hello " + dn);
		}
		
		public static void main(String[] args) {
			
			ScannerStudy study = new ScannerStudy();
			
			study.prepareScanner();
			
			Scanner scanner = study.getScanner();
			
			while (true) {
				System.out.print("������ �̸��� �Է��ϼ��� : ");
				String dogName = scanner.next();
				
				if (dogName.equals("quit")) {
					System.out.println("Goodby");
					break;
				}
				
				sayHello(dogName);
			}
			
			study.closeScanner();
			
		}
}
