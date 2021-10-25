package atm_project;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

	Admin admin;
	ArrayList<AccountInfo> acc = new ArrayList<>();
	ArrayList<Transaction_Log> transLog = new ArrayList<>();
	ATM atm;
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
			if(acc.get(i).getAccNum().equals(transAcc)){
				acc.get(i).setAccBal(acc.get(i).getAccBal() + transTotal);
				System.out.printf("%s 계좌의 잔액은 %d원 입니다! \n", acc.get(i).getAccNum(), acc.get(i).getAccBal());
			}
		}
		return 0;
	}

	protected int accBalSubReq(String transAcc, int transTotal){			//계좌 잔액 빼기
		for(int i=0; i<acc.size() ; i++){
			if(acc.get(i).getAccNum().equals(transAcc)){
				acc.get(i).setAccBal(acc.get(i).getAccBal() + transTotal);
				System.out.printf("%s 계좌의 잔액은 %d원 입니다! \n", acc.get(i).getAccNum(), acc.get(i).getAccBal());
			}
		}
		return 0;
	}

//	protected void atmLeftAddReq(int transCheonWon, int trans5CheonWon, int transManWon, int trans5ManWon) {
//		atmInfo.setCheonWon(atmInfo.getLeftCheonWon() + transCheonWon);
//		atmInfo.set5CheonWon(atmInfo.getLeft5CheonWon() + trans5CheonWon);
//		atmInfo.setManWon(atmInfo.getLeftManWon() + transManWon);
//		atmInfo.set5ManWon(atmInfo.getLeft5ManWon() + trans5ManWon);
//		System.out.println("ATM기 안에 남은 천원권 장 수는 : " + atmInfo.getLeftCheonWon());
//		System.out.println("ATM기 안에 남은 오천원권 장 수는 : " + atmInfo.getLeft5CheonWon());
//		System.out.println("ATM기 안에 남은 만원권 장 수는 : " + atmInfo.getLeftManWon());
//		System.out.println("ATM기 안에 남은 오만원권 장 수는 : " + atmInfo.getLeft5ManWon());
//	} //ATM 지폐 추가

//	protected void atmLeftSubReq(int transCheonWon, int trans5CheonWon, int transManWon, int trans5ManWon){
//		atmInfo.leftCheonWon = (atmInfo.leftCheonWon - transCheonWon);
//		atmInfo.left5CheonWon = (atmInfo.left5CheonWon - trans5CheonWon);
//		atmInfo.leftManWon = (atmInfo.leftManWon - transManWon);
//		atmInfo.left5ManWon = (atmInfo.left5ManWon - trans5ManWon);
//	} //ATM 지폐 빼기

//	protected void getATMLeft(){
//		System.out.println("ATM기 안에 남은 천원권 장 수는 : " + atm.leftCheonWon);
//		System.out.println("ATM기 안에 남은 오천원권 장 수는 : " + atm.left5CheonWon);
//		System.out.println("ATM기 안에 남은 만원권 장 수는 : " + atm.leftManWon);
//		System.out.println("ATM기 안에 남은 오만원권 장 수는 : " + atm.left5ManWon);
//	}
}