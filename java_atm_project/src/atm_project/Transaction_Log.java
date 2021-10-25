package atm_project;

import java.util.Date;

public class Transaction_Log  {

	Date date = new Date();
	protected String transAcc;			//거래 요청 계좌번호
	protected String reqUserName;		//거래요청 고객 이름
	String transDate = date.toString();		//거래 날짜
	protected int transTotal;
	protected int transManWon;		//만원거래량
	protected int trans5ManWon;		//만원거래량
	protected int transCheonWon;		//만원거래량
	protected int trans5CheonWon;		//만원거래량
	protected int accBal;				//거래 계좌 잔액

	protected  Transaction_Log (String transAcc, String reqUserName, int transTotal, int transManWon, int trans5ManWon, int transCheonWon, int trans5CheonWon, int accBal){
		this.transAcc = transAcc;
		this.reqUserName = reqUserName;
		this.transDate = date.toString();
		this.transTotal = transTotal;
		this.transManWon = transManWon;
		this.trans5ManWon = trans5ManWon;
		this.transCheonWon = transCheonWon;
		this.trans5CheonWon = trans5CheonWon;
		this.accBal = accBal;
	}
}
