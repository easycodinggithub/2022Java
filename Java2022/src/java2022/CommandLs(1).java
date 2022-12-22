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
		
		// currentDirectory : ���� ���� ���
		
		// commandLine : ls ��ɾ ����, ����� �׻� ls �� ������ ������ �ʿ���� ����
		
		File[] listOfSubfiles = currentDirectory.listFiles(); // ���� ������ ���� ��� ���� �迭
		
		for (File file : listOfSubfiles) {
			
			long time = 0; // ���������� ������ �ð�
			
			long size = 0; // ������ ũ�� 
			
			int count = 0; // B, KB, MB, GB, TB ���� ������ ũ�� ������ �����ϴ� ����
			
			String[] unit = {"","K", "M", "G", "T"}; // ���� ũ�� ������ ǥ���ϴ� �迭
			
			time = file.lastModified(); // ���������� ������ ��¥�� �и��ʷ� ��ȯ 
			
			size = file.length(); // ������ ũ��
				
			while(size > 1024 && count < 5) { // ���� ũ�� ���� ���ϱ�
				size /= 1024;
				count++;
			}
			
			if (file.isDirectory()) { // ���丮 ��� <DIR> ǥ��, ����ũ��, ���� ǥ�� X
				System.out.printf("%s %5s %5s%1s %s\n", formatDate(convertTODate(time)), "<DIR>", "", "", file.getName());
			}else { // �ƴϸ� <DIR> ǥ�� X, ���� ũ��, ���� ǥ��
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