package java2022;

import java.util.Scanner;

import java.util.Random;

public class RockPaperScissors {
	
	private static Scanner sc = new Scanner(System.in); // 키보드로부터 입력받는 스캐너
	
	private static int computer;
	
	private static String user;
	
	private static String[] rps = { "가위", "바위", "보" };
	
	private static int[] score = { 0, 0, 0 };
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		
		while(true) {
			
			System.out.print("가위바위보 중 하나를 입력하세요 (종료 \"quit\") : ");
			
			computer =  rand.nextInt(3)+1; 
			
			user = sc.nextLine();
			
			switch (user){
			case "가위": 
				result(1, computer); 
				break;
			case "바위": 
				result(2, computer); 
				break;
			case "보": 
				result(3, computer); 
				break;
			case "quit": 
				System.out.printf("총 전적 : %d승 %d패 %d무 \n", score[0], score[1], score[2]);
				return;
			default: 
				System.out.println("다시 입력해 주세요");
				continue;
			}
			
			System.out.printf("전적 : %d승 %d패 %d무 \n", score[0], score[1], score[2]);
		}
	}
	
	private static void result(int user, int computer) {
		
		int sort = user - computer;
		// 사용자 : 1, 2, 3
		// 컴퓨터 : 1, 2, 3
		// 승리조건 : 1-3 : -2, 2-1 : 1, 3-2 : 1
		// 패배조건 : 1-2 : -1, 2-3 : -1, 3-1 : 2 
		
		System.out.printf("%s VS %s : ", rps[user-1], rps[computer-1]);
		
		if (sort == -2 || sort == 1) {
			System.out.println("당신의 승리!");
			score[0]++;
		}else if(sort == -1 || sort == 2) {
			System.out.println("당신의 패배!");
			score[1]++;
		}else{
			System.out.println("무승부!");	
			score[2]++;
		}
	}
}
