package dgsw.hs.kr.whitepages;

import java.util.Scanner;

public class Insert {
	
	private static Scanner sc = new Scanner(System.in);
	
	private static String name, tel;
	
	public static void insert() {
		
		// insert 할 이름 입력 받기
		
		while(true) {
			System.out.print(" 등록할 이름 : ");
			name = sc.nextLine();	
			if(Check.checkName(name))
				break;
		}

		// insert 할 전화번호 입력 받기
		
		while(true) {
			System.out.print(" 등록할 전화번호 : ");
			tel = sc.nextLine();
			if (Check.checkTel(tel)) {
				if (ListSetting.select(tel).size() <= 0) {
					break;
				}else {
					System.out.println(" 입력하신 전화번호가 이미 있습니다.");
				}
			}
		}
		
		// insert
		
		if(ListSetting.insert(name, tel)) {
			System.out.println(" 전화번호가 등록되었습니다");
			
			// 파일에 리스트 결과 저장
			
			FileSetting.saveFile();
		}else{
			System.out.println(" 전화번호가 등록되지 않았습니다");
		}
	}
}
