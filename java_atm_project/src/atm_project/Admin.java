package atm_project;

import java.util.ArrayList;

public class Admin {

	protected String adminId;		//관리자 아이디
	protected int adminPWD;			//관리자 비밀번호
	protected String adminName;		//관리자 이름

	protected String getAdminName() { return adminName; }
	protected int getAdminPWD() { return adminPWD; }
	protected String getAdminId() { return adminId; }

	protected Admin (String adminId, int adminPWD, String adminName){
		this.adminName = adminId;
		this.adminPWD = adminPWD;
		this.adminName = adminName;
	}


	protected int adminBillAdd(){			//관리자 지폐 입금
		return 0;
	}

	protected int adminBillTake(){			//관리자 지폐 출금
		return 0;
	}

}
