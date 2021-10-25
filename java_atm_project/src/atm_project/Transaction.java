package atm_project;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

	ATMInfo atmInfo = new ATMInfo();
	Admin admin;
	ArrayList<AccountInfo> acc;
	ArrayList<Transaction_Log> transLog = new ArrayList<>();
	//Account ac = new Account(acc);


//	public Transaction(ArrayList<Transaction_Log> transLog) {
//		this.transLog = transLog;
//	}

	protected void transLogReq(String transAcc, String reqUserName, int transTotal, int transManWon, int trans5ManWon, int transCheonWon, int trans5CheonWon, int accBal){
		Transaction_Log newTransLog = new Transaction_Log(transAcc, reqUserName, transTotal, transManWon, trans5ManWon, transCheonWon, trans5CheonWon, accBal);
		transLog.add(newTransLog);
		//거래로그 기록요청
	}

	protected int accBalAddReq(String transAcc, int transTotal){			//계좌 잔액 더하기
		for(int i=0; i<acc.size() ; i++){
			if(acc.get(i).getAccNum() == transAcc){
				acc.get(i).setAccBal(acc.get(i).getAccBal() + transTotal);
			}
		}
		return 0;
	}

	protected int accBalSubReq(String transAcc, int transTotal){			//계좌 잔액 더하기
		for(int i=0; i<acc.size() ; i++){
			if(acc.get(i).getAccNum() == transAcc){
				acc.get(i).setAccBal(acc.get(i).getAccBal() - transTotal);
			}
		}
		return 0;
	}

	protected void atmLeftAddReq(int transCheonWon, int trans5CheonWon, int transManWon, int trans5ManWon) {
		atmInfo.leftCheonWon = (atmInfo.leftCheonWon + transCheonWon);
		atmInfo.left5CheonWon = (atmInfo.left5CheonWon + trans5CheonWon);
		atmInfo.leftManWon = (atmInfo.leftManWon + transManWon);
		atmInfo.left5ManWon = (atmInfo.left5ManWon + trans5ManWon);
	} //ATM 지폐 추가

	protected void atmLeftSubReq(int transCheonWon, int trans5CheonWon, int transManWon, int trans5ManWon){
		atmInfo.leftCheonWon = (atmInfo.leftCheonWon - transCheonWon);
		atmInfo.left5CheonWon = (atmInfo.left5CheonWon - trans5CheonWon);
		atmInfo.leftManWon = (atmInfo.leftManWon - transManWon);
		atmInfo.left5ManWon = (atmInfo.left5ManWon - trans5ManWon);
	} //ATM 지폐 빼기

	protected void getATMLeft(){
		System.out.println("ATM기 안에 남은 천원권 장 수는 : " + atmInfo.leftCheonWon);
		System.out.println("ATM기 안에 남은 오천원권 장 수는 : " + atmInfo.left5CheonWon);
		System.out.println("ATM기 안에 남은 만원권 장 수는 : " + atmInfo.leftManWon);
		System.out.println("ATM기 안에 남은 오만원권 장 수는 : " + atmInfo.left5ManWon);
	}
}
