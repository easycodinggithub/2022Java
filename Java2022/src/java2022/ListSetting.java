package java2022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListSetting {
	
	private static Scanner sc = new Scanner(System.in); // 키보드로부터 입력받는 스캐너
	
	private static String tel;
	
	// 리스트에 이름과 전화번호 입력
	
	public static boolean insert(String name, String tel) {
		if(!WhitePages.list.add(name + ":" + tel)) {
			return false;
		}
		return true;
	}
	
	// 리스트에 이름과 전화번호 삭제
	
	public static boolean delete(String name, List result) {
		
		if(result.size() == 1) { // 중복이 없으면
			
			WhitePages.list.remove(result.remove(0));
			return true;
		
		}else if(result.size() > 1){ // 중복이 있으면
			
			System.out.println(" 삭제할 이름이 여러개 입니다.");
			
			for (int i = 0; i < result.size(); i++) {
				String arr[] = ((String)result.get(i)).split(":");
				System.out.printf(" %s \n", arr[1]);
			}
			
			while(true) {
			
				System.out.print(" 삭제할 전화번호 : ");
				
				tel = sc.nextLine();
				
				if(Check.checkTel(tel)) {
					WhitePages.list.remove(name + ":" + tel);
					break;
				}
			}
			
			return true;
			
		}else {
			return false;
		}
	}
	
	// 리스트 정렬
	
	public static void sort() {
		WhitePages.list.sort(Comparator.naturalOrder());
	}
	
	// find 가 list에 "포함"되어 있는 결과 반환 ( contains )
	
	public static List select(String find) {
		
		List<String> result = new ArrayList<String>();
		
		for (String line : WhitePages.list){
			if (line.contains(find)) {
				result.add(line);
			}
		}
		
		return result;
	}
	
	// name 이 list에 "일치"하는 결과 반환 ( equals )
	
	public static List selectDuplication(String name) {
		
		List<String> result = new ArrayList<String>();
		
		for (String line : WhitePages.list){
			String arr[] = line.split(":");
			if (name.equals(arr[0])) {
				result.add(line);
			}
		}
		
		return result;
	}
}
