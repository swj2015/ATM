package atm_project;

import java.util.ArrayList;

class Transaction {

	ArrayList<AccountInfo> acc = new ArrayList<>();
	ArrayList<Transaction_Log> transLog = new ArrayList<>();

	protected void transLogReq(String transAcc, String reqUserName, String transDate, String transType, int transTotal, int transManWon, int trans5ManWon, int transCheonWon, int trans5CheonWon, int accBal) {
		Transaction_Log newTransLog = new Transaction_Log(transAcc, reqUserName, transDate, transType, transTotal, transManWon, trans5ManWon, transCheonWon, trans5CheonWon, accBal);
		transLog.add(newTransLog);
//		for(int i=0; i<transLog.size(); i++){
//			System.out.printf("계좌 : %s,사용자 이름 : %s, 거래 종류 : %s, 입금 금액 : %d, 만원 장수 : %d, 5만원 장수 : %d, 천원 장수 : %d, 오천원 장수 : %d, 계좌 잔액 : %d \n", transLog.get(i).getTransAcc(), transLog.get(i).getReqUserName(), transLog.get(i).getTransType(), transLog.get(i).getTransTotal(), transLog.get(i).getTransManWon(), transLog.get(i).getTrans5ManWon(), transLog.get(i).getTransCheonWon(), transLog.get(i).getTrans5CheonWon(), transLog.get(i).getAccBal());
//		}
		//거래로그 기록요청
	}

	protected ArrayList transLogPrint(){
		ArrayList<Transaction_Log> logSearch = new ArrayList<>();
		for(int i=0; i<transLog.size(); i++){
			Transaction_Log logSearchs = new Transaction_Log(transLog.get(i).getTransAcc(), transLog.get(i).getReqUserName(), transLog.get(i).getTransDate(), transLog.get(i).getTransType(), transLog.get(i).getTransTotal(), transLog.get(i).getTransManWon(), transLog.get(i).getTrans5ManWon(), transLog.get(i).getTransCheonWon(), transLog.get(i).getTrans5CheonWon(), transLog.get(i).getAccBal());
			logSearch.add(logSearchs);
//			System.out.printf("계좌 : %s,사용자 이름 : %s, 거래 시간 : %s, 거래 종류 : %s, 입금 금액 : %d, 만원 장수 : %d, 5만원 장수 : %d, 천원 장수 : %d, 오천원 장수 : %d, 계좌 잔액 : %d \n", transLog.get(i).getTransAcc(), transLog.get(i).getReqUserName(), transLog.get(i).getTransDate(), transLog.get(i).getTransType(), transLog.get(i).getTransTotal(), transLog.get(i).getTransManWon(), transLog.get(i).getTrans5ManWon(), transLog.get(i).getTransCheonWon(), transLog.get(i).getTrans5CheonWon(), transLog.get(i).getAccBal());
		}
		return logSearch;
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