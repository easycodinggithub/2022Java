package java2022;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class CommandCd extends AbstractCommand {

	public CommandCd(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		
		// currentDirectory : ���� ���� ���
		
		// commandLine : cd ���ϸ� ���·� ����
		
		// cd ���ϸ� => ���� ���丮�� �̵�
		
		// cd ..   => ���� ���丮�� �̵�
		
		String[] splitCommandLine = commandLine.split(" ",2); // cd �� ���ϸ��� �и�
		String absolutePath = currentDirectory.getAbsolutePath(); // ���� ���� ���
		
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