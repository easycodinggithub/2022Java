package java2022;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandLs extends AbstractCommand {
	public CommandLs(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		
		// currentDirectory : 현재 폴더 경로
		
		// commandLine : ls 명령어가 들어옴, 현재는 항상 ls 만 들어오기 떄문에 필요없는 변수
		
		File[] listOfSubfiles = currentDirectory.listFiles(); // 현재 폴더의 속한 모든 파일 배열
		
		for (File file : listOfSubfiles) {
			
			long time = 0; // 마지막으로 수정된 시간
			
			long size = 0; // 파일의 크기 
			
			int count = 0; // B, KB, MB, GB, TB 같은 파일의 크기 단위를 구분하는 변수
			
			String[] unit = {"","K", "M", "G", "T"}; // 파일 크기 단위를 표시하는 배열
			
			time = file.lastModified(); // 마지막으로 수정한 날짜를 밀리초로 반환 
			
			size = file.length(); // 파일의 크기
				
			while(size > 1024 && count < 5) { // 파일 크기 단위 정하기
				size /= 1024;
				count++;
			}
			
			if (file.isDirectory()) { // 디렉토리 라면 <DIR> 표시, 파일크기, 단위 표시 X
				System.out.printf("%s %5s %5s%1s %s\n", formatDate(convertTODate(time)), "<DIR>", "", "", file.getName());
			}else { // 아니면 <DIR> 표시 X, 파일 크기, 단위 표시
				System.out.printf("%s %5s %5s%1s %s\n", formatDate(convertTODate(time)), "", size, unit[count], file.getName());
			}
		}
		
		return currentDirectory;
	}
	
	public Date convertTODate(long unixTime) {
		return new Date(unixTime);
	}
	
	public String formatDate(Date date) {
		SimpleDateFormat dateFormat = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
}
