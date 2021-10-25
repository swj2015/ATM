package atm_project;

import java.util.ArrayList;

public class Transaction {

	ArrayList<AccountInfo> acc = new ArrayList<>();
	ArrayList<Transaction_Log> transLog = new ArrayList<>();

	protected void transLogReq(String transAcc, String reqUserName, int transTotal, int transManWon, int trans5ManWon, int transCheonWon, int trans5CheonWon, int accBal) {
		Transaction_Log newTransLog = new Transaction_Log(transAcc, reqUserName, transTotal, transManWon, trans5ManWon, transCheonWon, trans5CheonWon, accBal);
		transLog.add(newTransLog);
		//거래로그 기록요청
	}

	protected void transLogPrint(){
		for(int i=0; i<transLog.size(); i++){
			System.out.println(transLog.get(i));
		}
	}

	protected int accBalAddReq(String transAcc, int transTotal) {            //계좌 잔액 더하기
		for (int i = 0; i < acc.size(); i++) {
			if (acc.get(i).getAccNum().equals(transAcc)) {
				acc.get(i).setAccBal(acc.get(i).getAccBal() + transTotal);
				System.out.printf("%s 계좌의 잔액은 %d원 입니다! \n", acc.get(i).getAccNum(), acc.get(i).getAccBal());
			}
		}
		return 0;
	}

	protected int accBalSubReq(String transAcc, int transTotal) {            //계좌 잔액 빼기
		for (int i = 0; i < acc.size(); i++) {
			if (acc.get(i).getAccNum().equals(transAcc)) {
				acc.get(i).setAccBal(acc.get(i).getAccBal() + transTotal);
				System.out.printf("%s 계좌의 잔액은 %d원 입니다! \n", acc.get(i).getAccNum(), acc.get(i).getAccBal());
			}
		}
		return 0;
	}
}