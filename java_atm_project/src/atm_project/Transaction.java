package atm_project;

import java.util.Date;

public class Transaction {
	
	protected String transAcc;			//거래 요청 계좌번호
	protected String reqUserName;		//거래요청 고객 이름
	Date transDate = new Date();		//거래 날짜
	protected int transBillNums;		//거래량
	protected long accBal;				//거래 계좌 잔액
	
	
	
	
	private void transLogReq(){			//거래로그 기록요청
		
	}
	
	protected int accBalChangeReq(){			//계좌 잔액 정보 변경
		
		return 0;
	}
	
	protected int atmLeftChangeReq(){				//ATM 잔금 정보 변경
		
		return 0;
	}
}
