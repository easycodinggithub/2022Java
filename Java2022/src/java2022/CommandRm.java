package dgsw.hs.kr.command;

import java.io.File;
import java.util.Scanner;

public class CommandRm extends AbstractCommand {

	private static Scanner sc = new Scanner(System.in); // 키보드로부터 입력받는 스캐너
	
	public CommandRm(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		
		
		// currentDirectory : 현재 폴더 경로
		
		// commandLine : rm 파일명 형태로 들어옴
		
		// rm 파일명 => 파일명 삭제
		
		String[] splitCommandLine = commandLine.split(" ",2); // rm 와 파일명을 분리
		
		String absolutePath = currentDirectory.getAbsolutePath() + "\\" + splitCommandLine[1]; // 현재 파일 경로
		
		String check = "파일";
		
		System.out.println(absolutePath);
		
		File file = new File(absolutePath);
		
		if (file.exists() && file.isFile()) {

			if(check()){
				System.out.println("파일이 삭제되었습니다.");
				file.delete();
			}else {
				System.out.println("파일이 삭제되지 않았습니다.");
			}
			
		}else if(file.exists() && file.isDirectory()) {
			
			File[] file_list = file.listFiles();
			
			for (int j = 0; j < file_list.length; j++) {
				file_list[j].delete(); //파일 삭제 
			}
			
			if(check()){
				System.out.println("폴더가 삭제되었습니다.");
				file.delete();
			}else {
				System.out.println("폴더가 삭제되지 않았습니다.");
			}
				
		}else {
			System.out.println("파일(폴더)을 찾을 수 없습니다.");
		}

		return currentDirectory;
	}
	
	private static boolean check() {
		System.out.print("정말로 삭제하시겠습니까? ( 삭제하려면 Y or y 입력 )");
		
		String checkRm = sc.nextLine(); 
		
		if("Y".equals(checkRm) || "y".equals(checkRm)) {	
			return true;
		}else {
			return false;
		}
	}
}
