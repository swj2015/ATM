package atm_project;

import java.util.ArrayList;
import java.util.List;

public class Admin {

	List<Admin> admin;
	Transaction trans;
	ATMInfo atmInfo;

	protected String adminId;		//관리자 아이디
	protected int adminPWD;			//관리자 비밀번호
	protected String adminName;		//관리자 이름

	protected String getAdminName() { return adminName; }
	protected int getAdminPWD() { return adminPWD; }
	protected String getAdminId() { return adminId; }

	protected Admin (String adminId, int adminPWD, String adminName){
		this.adminId = adminId;
		this.adminPWD = adminPWD;
		this.adminName = adminName;
	}


	protected int adminIdentification(String adminId, int adminPWD){ //관리자로그인
		for(int i=0; i<admin.size() ; i++){
			if (adminId == admin.get(i).getAdminId() && adminPWD == admin.get(i).getAdminPWD()){
				System.out.printf("%c 회원이 로그인에 성공했습니다!", adminName);
				return 1000;
			}
			else {
				System.out.println("존재하지 않는 아이디 혹은 비밀번호입니다!");
				return 2000;
			}
		}
		return 0;
	} //1000 : 성공 2000 : 오류

	protected int adminBillAdd(int cheonWon, int ohCheonWon, int manWon, int ohManWon){
		trans.atmLeftAddReq(cheonWon, ohCheonWon, manWon, ohManWon);
		System.out.println("성공적으로 지폐를 보충했습니다!");
		return 1000;
	}//관리자 지폐 입금

	protected int adminBillTake(int cheonWon, int ohCheonWon, int manWon, int ohManWon){
		if(atmInfo.leftCheonWon < cheonWon || atmInfo.left5CheonWon < ohCheonWon || atmInfo.leftManWon < manWon || atmInfo.left5ManWon < ohManWon){
			System.out.println("ATM기 내의 지폐가 부족합니다!");
			return 2001;
		}
		trans.atmLeftSubReq(cheonWon, ohCheonWon, manWon, ohManWon);
		System.out.println("성공적으로 지폐를 꺼냈습니다!");
		return 1000;
	}//관리자 지폐 출금

}
