package atm_project;

import java.util.ArrayList;

public class ATM {
	
	protected int leftManWon;			//만원권 남은 장수
	protected int left5ManWon;			//5만원권 남은 장수
	protected int leftCheonWon;			//천원권 남은 장수
	protected int left5CheonWon;			//5천원권 남은 장수
	
	protected ArrayList<String> atmPreInfo = new ArrayList<>();		//ATM 거래 이전 정보를 저장

	// 주석
	
	protected void transactionReq(){			//거래요청
		
	}
	
	protected int leftBill_1(){			//ATM 전체 남은 만원권 장수 반환
		
		return leftManWon;
	}
	protected int leftBill_2(){			//ATM 전체 남은 5만원권 장수 반환
		
		return left5ManWon;
	}
	protected int leftBill_3(){			//ATM 전체 남은 천원권 장수 반환
	
		return leftCheonWon;
	}
	protected int leftBill_4(){			//ATM 전체 남은 5천원권 장수 반환
	
		return left5CheonWon;
	}
	


}
