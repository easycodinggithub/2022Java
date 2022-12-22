package java2022;

import java.util.Scanner;

import kr.hs.dgsw.java.dept23.d0317.ScannerStudy;

public class FriendsFind2 {

public static void main(String[] args) {
		
		String[] friend = {"������","������","����","����","��μ�","������","�ں���","�ڼ���","������","������","�տ�","����","����","������","������", "�̽¹�", "����ȣ","�ֹ���","�ѻ��"};
		ScannerStudy study = new ScannerStudy();
		study.prepareScanner();
		
		Scanner scanner = study.getScanner();
		
		while (true) {
			System.out.print("�̸��� �Է��ϼ��� : ");
			
			String value = scanner.next();
			
			if ("quit".equals(value)) {
				break;
			}else {
				for	(int i = 0; i < friend.length; i++) {
					if (value.equals(friend[i])) {
						System.out.printf("%s : %d�� \n", friend[i], i+1);
					}else {
						System.out.printf("���� �̸��Դϴ�. \n");
					}
				}
			}
		}
		
		study.closeScanner();
	}
}
