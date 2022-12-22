package java2022;

// 이름, 전화번호, 검색 결과를 정규표현식으로 확인하는 클래스

public class Check {
	
	// 이름 확인
	
	public static boolean checkName(String name) {
		if (name.length() < 2 || name.length() > 10) {
			System.out.println(" 이름은 2 ~ 10 자로 입력하세요.");
			return false;
		}
		if(!name.matches("^[가-힣]*$")) {
            System.out.println(" 이름은 한글만으로 입력하세요.");
			return false;
		}
		return true;
	}
	
	// 전화번호 확인
	
	public static boolean checkTel(String tel) {
		if(!tel.matches("\\d{3}-\\d{4}-\\d{4}")) {
            System.out.println(" 전화번호는 000-0000-0000 형태로 입력하세요.");
			return false;
		}
		return true;
	}
	
	// 검색결과 확인
	
	public static boolean checkFind(String find) {
		if (!(find.matches("^[가-힣]*$") || find.matches("^[0-9\\-]*$"))) {
			System.out.println(" 검색할 형식에 맞지 않습니다.");
			return false;
		}
		return true;
	}
}
