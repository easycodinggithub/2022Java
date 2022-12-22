package java2022;

import java.io.File;

public class CommandCd extends AbstractCommand {
	public CommandCd(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		
		// currentDirectory : 현재 폴더 경로
		
		// commandLine : cd 파일명 형태로 들어옴
		
		// cd 파일명 => 하위 디렉토리로 이동
		
		// cd ..   => 상위 디렉토리로 이동
		
		String[] splitCommandLine = commandLine.split(" ",2); // cd 와 파일명을 분리
		String absolutePath = currentDirectory.getAbsolutePath(); // 현재 파일 경로
		
		if (splitCommandLine[1].equals("..")) {
			if (absolutePath.equals("C:\\")) { 
				System.out.println("cannot find the path");
				return currentDirectory;
			}
			absolutePath = absolutePath.substring(0, absolutePath.lastIndexOf("\\"));
		}else {
			absolutePath = absolutePath + "\\" + splitCommandLine[1];
		}
		
		File file = new File(absolutePath);

		boolean exist = file.exists();
		
		if(exist == false || file.isFile()) {
			System.out.println("cannot find the path");
			return currentDirectory;
		}
		
		return file;
	}
}
