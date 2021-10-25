package atm_project;

import java.util.List;
import java.util.ArrayList;

public class Admin {

	ArrayList<AdminInfo> admin;
	ArrayList<Transaction_Log> transLog;
	Transaction trans = new Transaction();
	ATM atm;

	public Admin(ArrayList<AdminInfo> admin) {
		this.admin = admin;
	}

	protected int adminIdentification(String adminId, int adminPWD){ //관리자로그인
		for(int i=0; i<admin.size() ; i++){
			if (adminId.equals(admin.get(i).getAdminId()) && adminPWD == admin.get(i).getAdminPWD()){
				System.out.printf("%s 회원이 로그인에 성공했습니다! \n", admin.get(i).getAdminName());
				return 1000;
			}

		}
		System.out.println("존재하지 않는 아이디 혹은 비밀번호입니다! \n");
		return 2000;
	} //1000 : 성공 2000 : 오류

//	protected int adminBillAdd(int cheonWon, int ohCheonWon, int manWon, int ohManWon){
//		atm.billAdd(cheonWon,ohCheonWon, manWon, ohManWon);
//		System.out.println("성공적으로 지폐를 보충했습니다!");
//		System.out.println("ATM기 안에 남은 천원권 장 수는 : " + atm.leftCheonWon);
//		System.out.println("ATM기 안에 남은 오천원권 장 수는 : " + atm.left5CheonWon);
//		System.out.println("ATM기 안에 남은 만원권 장 수는 : " + atm.leftManWon);
//		System.out.println("ATM기 안에 남은 오만원권 장 수는 : " + atm.left5ManWon);
//		return 1000;
//	}//관리자 지폐 입금
//
//	protected int adminBillTake(int cheonWon, int ohCheonWon, int manWon, int ohManWon){
//		if(atm.leftCheonWon < cheonWon || atm.left5CheonWon < ohCheonWon || atm.leftManWon < manWon || atm.left5ManWon < ohManWon){
//			System.out.println("ATM기 내의 지폐가 부족합니다!");
//			return 2001;
//		}
//		//trans.atmLeftSubReq(cheonWon, ohCheonWon, manWon, ohManWon);
//		System.out.println("성공적으로 지폐를 꺼냈습니다!");
//		return 1000;
//	}//관리자 지폐 출금

}