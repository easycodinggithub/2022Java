package java2022;

import java.util.Scanner;

import kr.hs.dgsw.java.dept23.d0317.ScannerStudy;

public class FriendsFind {
	
	public static void main(String[] args) {
		
		String[] friend = {"������","������","����","����","��μ�","������","�ں���","�ڼ���","������","������","�տ�","����","����","������","������", "�̽¹�", "����ȣ","�ֹ���","�ѻ��"};
		ScannerStudy study = new ScannerStudy();
		study.prepareScanner();
		
		Scanner scanner = study.getScanner();
		
		while (true) {
			System.out.print("��ȣ�� �Է��ϼ��� : ");
			
			int intValue = scanner.nextInt();
			
			if (intValue == -1) {
				break;
			}
			
			if (intValue <= friend.length) {
			
			System.out.printf("%d�� : %s \n", intValue, friend[intValue-1]);
			
			}else {
				System.out.printf("���� ��ȣ�Դϴ�. \n");
			}
		}
		
		study.closeScanner();
	}
	
}
