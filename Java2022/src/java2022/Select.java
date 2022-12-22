package java2022;

import java.util.List;
import java.util.Scanner;

public class Select {
	
	private static String find;
	
	private static Scanner sc = new Scanner(System.in);
	
	private static List<String> result;
	
	public static void select() {
		
		// select 할 이름 이나 전화번호 입력 받기
		
		while(true) {
			System.out.print(" 검색할 이름 또는 전화번호 : ");
			find = sc.nextLine();
			if(Check.checkFind(find))
				break;
		}
		
		ListSetting.sort();
		
		result = ListSetting.select(find);
		
		if (result.size() <= 0) {
			System.out.println(" 검색 결과가 없습니다");
		}else {
			System.out.println(" 검색 결과 : " + result.size());
			for (String line : result) {
				System.out.printf(" %s \n", line);
			}
		}
	}
	
	public static void selectAll() {
		ListSetting.sort();
		System.out.printf("\n 검색 결과 : %d \n", WhitePages.list.size());
		for (String line : WhitePages.list) {
			System.out.printf(" %s \n", line);
		}
	}
}
