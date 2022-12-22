package java2022;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// 파일 존재 여부, 만들기, 로드, 저장을 하는 클래스

public class FileSetting {
	
	private static FileWriter fileWrite;
	
	// 파일 존재 여부 확인
	
	public static boolean fileExist() {
		return WhitePages.file.exists();
	}
	
	// 파일 만들기
	
	public static boolean fileMake() {
		try {
			WhitePages.file.createNewFile(); // 파일 생성
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	// 파일 로드 ( 파일을 리스트에 저장 )
	
	public static void loadFile() {
		try {
			System.out.printf(" %s 파일 로드 성공 \n\n", WhitePages.filePath);
			WhitePages.list = Files.readAllLines(Paths.get(WhitePages.filePath));
		} catch (IOException e) {
			System.out.printf(" %s 파일 로드 실패 \n\n", WhitePages.filePath);
			Quit.quit();
		}
	}
	
	// 파일 저장 ( 리스트를 파일에다 저장 )
	
	public static void saveFile() {
		try {
			System.out.printf(" %s 파일 저장 성공 \n\n", WhitePages.filePath);
			fileWrite = new FileWriter(WhitePages.file);
			// fileWrite = new FileWriter(file, true);
			for (String line : WhitePages.list) {				
				fileWrite.write(line + "\r\n");
			}
			fileWrite.close();			
        } catch (IOException e) {
        	System.out.printf(" %s 파일 저장 실패 \n\n", WhitePages.filePath);
			Quit.quit();
        }
	}

}
