package dgsw.hs.kr.whitepages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class WhitePages {
	
	protected static String filePath = "D:\\WhitePages.txt"; // 전화번호와 이름이 저장될 파일 경로
	
	protected static File file = new File(filePath); // 저장 할 파일
	
	protected static List<String> list; // 파일과 연동할 리스트
	
	protected static Scanner sc = new Scanner(System.in); // 키보드로부터 입력받는 스캐너
	
	public static void main(String[] args) {
		
		System.out.printf("< 전화번호부 프로그램 > \n\n");
	
		// 파일 존재 확인
		if(!FileSetting.fileExist()) {
			// 파일이 없으면 파일 생성
			if(FileSetting.fileMake()) {
				System.out.printf("< %s 파일 생성 성공 > \n\n", filePath);
			}else {
				System.out.printf("< %s 파일 생성 실패 > \n\n", filePath);
				return;
			}
		}
		
		// 처음에 파일 내용 불러와서 list 에 저장
		
		FileSetting.loadFile();
		
		// 메뉴 출력
		
		outputMenu();
		
		while(true) {
			System.out.print(" Command : ");
			sortMenu(inputMenu());
		}
	}
	
	private static void outputMenu() {
		System.out.println("===== Menu =====");
		System.out.println(" 1. 전화번호 등록");
		System.out.println(" 2. 전화번호 삭제");
		System.out.println(" 3. 전화번호 검색");
		System.out.println(" 4. 전화번호 전체검색");
		System.out.println(" 0. 프로그램 종료");
		System.out.println("================");
	}
	
	private static String inputMenu() {
		return sc.nextLine();
	}
	
	private static void sortMenu(String command) {
		switch (command) {
		case "1": Insert.insert(); break;
		case "2": Delete.delete(); break;
		case "3": Select.select(); break;
		case "4": Select.selectAll(); break;
		case "0": Quit.quit(); break;
		default: System.out.println("다시 입력해 주세요");
		}
	}
}
