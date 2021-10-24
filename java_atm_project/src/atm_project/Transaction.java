package atm_project;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

	ATMInfo atmInfo;
	List<AccountInfo> acc;
	List<Transaction_Log> transLog;

	public Transaction(ArrayList<Transaction_Log> transLog) {
		this.transLog = transLog;
	}

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

	protected void atmLeftAddReq(int transCheonWon, int trans5CheonWon, int transManWon, int trans5ManWon){
		atmInfo.setCheonWon(atmInfo.getLeftCheonWon() + transCheonWon);
		atmInfo.set5CheonWon(atmInfo.getLeft5CheonWon() + trans5CheonWon);
		atmInfo.setManWon(atmInfo.getLeftManWon() + transManWon);
		atmInfo.set5ManWon(atmInfo.getLeft5ManWon() + trans5ManWon);
	} //ATM 지폐 추가

	protected void atmLeftSubReq(int transCheonWon, int trans5CheonWon, int transManWon, int trans5ManWon){
		atmInfo.setCheonWon(atmInfo.getLeftCheonWon() - transCheonWon);
		atmInfo.set5CheonWon(atmInfo.getLeft5CheonWon() - trans5CheonWon);
		atmInfo.setManWon(atmInfo.getLeftManWon() - transManWon);
		atmInfo.set5ManWon(atmInfo.getLeft5ManWon() - trans5ManWon);
	} //ATM 지폐 빼기

}
