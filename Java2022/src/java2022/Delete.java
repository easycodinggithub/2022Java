package java2022;

import java.util.Scanner;

public class Delete {
	
	private static String name;
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void delete() {
		
		// delete 할 이름 입력 받기
		
		while(true) {
			System.out.print(" 삭제할 이름 : ");
			name = sc.nextLine();
			if(Check.checkName(name) || Check.checkTel(name))
				break;
		}
		
		// delete
		
		if(ListSetting.delete(name, ListSetting.selectDuplication(name))) {
			System.out.println(" 전화번호가 삭제되었습니다");
			
			// 파일에 리스트 결과 저장
			
			FileSetting.saveFile();
		}else {
			System.out.println(" 삭제할 전화번호가 없습니다");
		}
	}
}
