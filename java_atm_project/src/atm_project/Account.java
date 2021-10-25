package atm_project;

import java.util.ArrayList;
import java.util.List;

public class Account {

	Transaction transaction;
	ATMInfo atmInfo;
	ArrayList<AccountInfo> acc;

	public Account(ArrayList<AccountInfo> acc) {
		this.acc = acc;
	}

	protected void depositReq(String accNum, int accPWD, int total, int cheonWon, int ohCheonWon, int manWon, int ohManWon){ //입금요청
		for (int i=0 ; i<acc.size(); i++){
			if (accNum == acc.get(i).getAccNum() && accPWD == acc.get(i).getAccPWD()){
				transaction.accBalAddReq(accNum, total);
			}
			transaction.transLogReq(accNum, acc.get(i).getAccUser(), -total, manWon, ohManWon, cheonWon, ohCheonWon, acc.get(i).getAccBal());
		}
		transaction.atmLeftAddReq(cheonWon, ohCheonWon, manWon, ohManWon);
	}
	
	protected int withdrawReq(String accNum, int accPWD, int total, int cheonWon, int ohCheonWon, int manWon, int ohManWon){//출금요청
		for (int i=0 ; i<acc.size(); i++) {
			if (accNum == acc.get(i).getAccNum() && accPWD == acc.get(i).getAccPWD()){
				if (acc.get(i).getAccBal() < total){
					System.out.println ("계좌의 잔액이 부족합니다!");
					return 2001;
				}
				if(atmInfo.leftCheonWon < cheonWon || atmInfo.left5CheonWon < ohCheonWon || atmInfo.leftManWon < manWon || atmInfo.left5ManWon < ohManWon){
					System.out.println("ATM기 내의 지폐가 부족합니다!");
					return 2002;
				}
				transaction.accBalSubReq(accNum, total);
				break;
			}
			transaction.transLogReq(accNum, acc.get(i).getAccUser(), total, manWon, ohManWon, cheonWon, ohCheonWon, acc.get(i).getAccBal());
		}
		transaction.atmLeftSubReq(cheonWon, ohCheonWon, manWon, ohManWon);

		return 1000;
	}
	
	protected int remitReq(String sendAccNum, int sendAccPWD, String sentAccNum, int total){				//거래요청(타계좌간거래)
		for (int i=0 ; i<acc.size(); i++) {
			if (sendAccNum == acc.get(i).getAccNum() && sendAccPWD == acc.get(i).getAccPWD()){
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
}