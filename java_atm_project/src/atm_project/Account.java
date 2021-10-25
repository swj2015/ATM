package atm_project;

import java.util.ArrayList;
import java.util.List;

public class Account {

	Transaction transaction = new Transaction();
	ATMInfo atmInfo;
	ArrayList<AccountInfo> acc;

	public Account(ArrayList<AccountInfo> acc) {
		this.acc = acc;
	}

	protected int depositReq(String accNum, int accPWD, int total, int cheonWon, int ohCheonWon, int manWon, int ohManWon){ //입금요청
		for (int i=0 ; i<acc.size(); i++){
			if (accNum.equals(acc.get(i).getAccNum()) && accPWD == acc.get(i).getAccPWD()){
				transaction.accBalAddReq(accNum, total);
				transaction.transLogReq(accNum, acc.get(i).getAccUser(), total, manWon, ohManWon, cheonWon, ohCheonWon, acc.get(i).getAccBal());
				transaction.atmLeftAddReq(cheonWon, ohCheonWon, manWon, ohManWon);
				System.out.println("입금이 정상적으로 실행되었습니다!");
				System.out.println("계좌에 남은 금액은 :" + acc.get(i).getAccBal() + "입니다!");
				return 1000;
			}
		}
		System.out.println("계좌 정보가 일치하지 않습니다!");
		return 2000;
	}
	
	protected int withdrawReq(String accNum, int accPWD, int total, int cheonWon, int ohCheonWon, int manWon, int ohManWon){//출금요청
		for (int i=0 ; i<acc.size(); i++) {
			if (accNum.equals(acc.get(i).getAccNum()) && accPWD == acc.get(i).getAccPWD()) {
				if (acc.get(i).getAccBal() < total) {
					System.out.println("계좌의 잔액이 부족합니다!");
					return 2001;
				}
				if (atmInfo.leftCheonWon < cheonWon || atmInfo.left5CheonWon < ohCheonWon || atmInfo.leftManWon < manWon || atmInfo.left5ManWon < ohManWon) {
					System.out.println("ATM기 내의 지폐가 부족합니다!");
					return 2002;
				}
				transaction.accBalSubReq(accNum, total);
				transaction.transLogReq(accNum, acc.get(i).getAccUser(), -total, manWon, ohManWon, cheonWon, ohCheonWon, acc.get(i).getAccBal());
				transaction.atmLeftSubReq(cheonWon, ohCheonWon, manWon, ohManWon);
				return 1000;
			}
		}
		System.out.println("계좌 정보가 일치하지 않습니다!");
		return 2000;
	}
	
	protected int remitReq(String sendAccNum, int sendAccPWD, String sentAccNum, int total){				//거래요청(타계좌간거래)
		for (int i=0 ; i<acc.size(); i++) {
			if (sendAccNum.equals(acc.get(i).getAccNum()) && sendAccPWD == acc.get(i).getAccPWD()){
				if (acc.get(i).getAccBal() < total){
					System.out.println ("계좌의 잔액이 부족합니다!");
					return 2001;
				}
				transaction.accBalSubReq(sendAccNum, total);
			}
			if (sentAccNum == acc.get(i).getAccNum()){
				transaction.accBalAddReq(sentAccNum, total);
			}
		}
		return 1000;
	}
	protected void depositSearch(String userId){//유저 계좌 조회 -> 가지고 있는 전체 계좌를 보여줌. 로그인 한 상태이고 무조건 1개 이상의 계좌가 있다고 가정. 오류처리 안함
		System.out.println(acc.get(0).getAccUser());
		for (int j = 0; j < acc.size(); j++) {
			if (userId.equals(acc.get(j).getAccUser())) {
				if (acc.get(j).getAccType() == 1) {
					System.out.printf("유저의 %s 입출금 계좌의 잔액은 %d원 입니다! \n", acc.get(j).getAccNum(), acc.get(j).getAccBal());
				}
				if (acc.get(j).getAccType() == 2) {
					System.out.printf("유저의 %s 정기예금 계좌의 잔액은 %d원 입니다! \n", acc.get(j).getAccNum(), acc.get(j).getAccBal());
				}
				if (acc.get(j).getAccType() == 3) {
					System.out.printf("유저의 %s 정기적금 계좌의 잔액은 %d원 입니다! \n", acc.get(j).getAccNum(), acc.get(j).getAccBal());
				}
			}
		}
	}
}
