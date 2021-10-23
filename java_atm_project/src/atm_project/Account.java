package atm_project;

import java.util.ArrayList;
import java.util.List;

public class Account {

	Transaction transaction;
	ATMInfo atmInfo;
	protected List<Account> acc;
	protected List<Transaction> trans;

	protected String accUser;       //계좌소유유저이름
	protected String accNum;		//계좌번호
	protected int accBal;			//계좌잔액
	protected int accType;			//계좌종류 => 1.입출금, 2.정기예금, 3.정기적금
	protected int accPWD;			//계좌 비밀번호

	protected String getAccUser() { return accUser; }
	protected String getAccNum() { return  accNum; }
	protected int getAccBal() { return accBal; }
	protected int getAccType() { return  accType; }
	protected int getAccPWD() { return accPWD; }
	protected void setAccBal(int accBal) { this.accBal = accBal; }

	protected Account(String accUser, String accNum, int accBal, int accType, int accPWD){
		this.accUser = accUser;
		this.accNum = accNum;
		this.accBal = accBal;
		this.accType = accType;
		this.accPWD = accPWD;
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
