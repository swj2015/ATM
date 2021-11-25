package atm_project;

import java.util.List;
import java.util.ArrayList;

class Admin {

	ArrayList<AdminInfo> admin;

	Admin(ArrayList<AdminInfo> admin) {
		this.admin = admin;
	}

	protected int adminIdentification(String adminId, int adminPWD) { //관리자로그인
		for (int i = 0; i < admin.size(); i++) {
			if (adminId.equals(admin.get(i).getAdminId()) && adminPWD == admin.get(i).getAdminPWD()) {
				System.out.printf("%s 회원이 로그인에 성공했습니다! \n", admin.get(i).getAdminName());
				return 1000;
			}

		}
		System.out.println("존재하지 않는 아이디 혹은 비밀번호입니다! \n");
		return 2000;
	} //1000 : 성공 2000 : 오류
}