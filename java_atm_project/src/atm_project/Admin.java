package atm_project;

import java.util.ArrayList;

public class Admin {

	protected String adminId;		//관리자 아이디
	protected int adminPWD;			//관리자 비밀번호
	protected String adminName;		//관리자 이름
	protected String getAdminName() { return adminName; }
	protected int getAdminPWD() { return adminPWD; }
	protected String getAdminId() { return adminId; }
	
	ATM atm = new ATM();
	
	int Man = atm.leftManWon;
	int fiveMan = atm.left5ManWon;
	int Cheon = atm.leftCheonWon;
	int fiveCheon = atm.left5CheonWon;
	
	
	protected int adminLogin() {		// 관리자 로그인 성공하면
		System.out.println("System: 관리자 계정으로 로그인하였습니다.\n");
		System.out.printf("[ ATM 내부 지폐 잔여액 ]\n 5만원권: %d장, 1만원권: %d장, 5천원권: %d장, 1천원권: %d장\n", fiveMan, Man, fiveCheon, Cheon);
		
		System.out.println("사용할 작업 번호를 입력하세요.\n1. 부족 지폐 충전하기, 2. 내부 지폐 인출하기\n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n == 1) {
			
		}
		
		
		return 0;
	}
	
	protected int adminBillAdd(){			//관리자 지폐 입금
		return 0;
	}

	protected int adminBillTake(){			//관리자 지폐 출금
		return 0;
	}

}
