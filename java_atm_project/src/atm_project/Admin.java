package atm_project;

import java.util.ArrayList;
import java.util.List;

public class Admin {

	List<Admin> admin;
	Transaction trans;
	ATMInfo atmInfo;

	protected String adminId;		//관리자 아이디
	static protected int adminPWD;			//관리자 비밀번호
	protected String adminName;		//관리자 이름

	
	static ArrayList<String> admin = new ArrayList<>();
	static ArrayList<Integer> adPassword = new ArrayList<>();
	
	protected Admin (String adminId, String adminName){
		this.adminId = adminId;
		this.adminName = adminName;
		
		admin.add(adminId);
		admin.add(adminName);
		
		
	}
	
	static protected void adPwd (int AdminPWD) {
		adminPWD = AdminPWD;
		adPassword.add(adminPWD);
	}

	String getAdminId(int cnt) {
		return admin.get(0 + cnt*2);
	}
	
	String getAdminName(int cnt) {
		return admin.get(1 + cnt*2);
	}
	int getAdminPWD(int cnt) {
		return adPassword.get(cnt);
	}
	
	protected int adminIdentification(String adminId, int adminPWD){ //관리자로그인
		
		for(int i = 0; i<2; i++) {
			
			String name = getAdminName(i);
			String Id = getAdminId(i);
			
			if (adminId.equals(Id)) {
				if(adminPWD == getAdminPWD(i)){
					System.out.printf("%s (이)가 로그인에 성공했습니다!\n", name);
					return 1000;
				}
				else continue;
				
			}
		}
		
		System.out.println("존재하지 않는 아이디 혹은 비밀번호입니다!");
				
		return 2000;
		
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
