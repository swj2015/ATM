package atm_project;

import java.util.ArrayList;
import java.util.Date;

class Account {

	Date date = new Date();
	Transaction transaction = new Transaction();
	ArrayList<AccountInfo> acc;

	Account(ArrayList<AccountInfo> acc) {
		this.acc = acc;
	}

	protected int depositReq(String accNum, int accPWD, int total, int cheonWon, int ohCheonWon, int manWon, int ohManWon){ //입금요청
		for (int i=0 ; i<acc.size(); i++){
			if (accNum.equals(acc.get(i).getAccNum()) && acc.get(i).getAccType() != 1){
				System.out.println("입출금계좌로만 입금이 가능합니다!");
				return 2003;
			}
			if (accNum.equals(acc.get(i).getAccNum()) && accPWD == acc.get(i).getAccPWD()){
				for(int j=0; j<acc.size() ; j++){
					if(acc.get(j).getAccNum().equals(accNum)){
						acc.get(j).setAccBal(acc.get(j).getAccBal() + total);
					}
				}
				transaction.transLogReq(accNum, acc.get(i).getAccUser(), date.toString(), "입금", total, manWon, ohManWon, cheonWon, ohCheonWon, acc.get(i).getAccBal());
				System.out.println("입금이 정상적으로 실행되었습니다!");
				System.out.println("계좌에 남은 금액은 :" + acc.get(i).getAccBal() + "입니다!");
				return 1000;
			}
		}
		System.out.println("계좌 정보가 일치하지 않습니다!");
		return 2000;
	}

	protected ArrayList transLogSearch(){
		System.out.println("Transaction Log 조회!");
		return transaction.transLogPrint();
	}
	
	protected int withdrawReq(String accNum, int accPWD, int total, int cheonWon, int ohCheonWon, int manWon, int ohManWon){//출금요청
		for (int i=0 ; i<acc.size(); i++) {
			if (accNum.equals(acc.get(i).getAccNum()) && accPWD == acc.get(i).getAccPWD()) {
				if (accNum.equals(acc.get(i).getAccNum()) && acc.get(i).getAccType() != 1){
					System.out.println("입출금계좌로만 출금이 가능합니다!");
					return 2003;
				}
				if (acc.get(i).getAccBal() < total) {
					System.out.println("계좌의 잔액이 부족합니다!");
					return 2001;
				}
				for(int j=0; j<acc.size() ; j++){
					if(acc.get(j).getAccNum().equals(accNum)){
						acc.get(j).setAccBal(acc.get(j).getAccBal() - total);
					}
				}
				transaction.transLogReq(accNum, acc.get(i).getAccUser(), date.toString(), "출금", -total, manWon, ohManWon, cheonWon, ohCheonWon, acc.get(i).getAccBal());
				System.out.println("출금이 정상적으로 실행되었습니다!");
				System.out.println("계좌에 남은 금액은 :" + acc.get(i).getAccBal() + "입니다!");
				return 1000;
			}
		}
		System.out.println("계좌 정보가 일치하지 않습니다!");
		return 2000;
	}
	
	protected int remitReq(String sendAccNum, int sendAccPWD, String sentAccNum, int total){//거래요청(타계좌간거래)
		int cnt = 0; int send = 0; int sent = 0;
		for (int i=0 ; i<acc.size(); i++) {
			if (sentAccNum.equals(acc.get(i).getAccNum()) && acc.get(i).getAccType() != 1){
				System.out.println("입출금계좌로만 입금이 가능합니다!");
				return 2003;
			}
			if (sendAccNum.equals(acc.get(i).getAccNum()) && sendAccPWD == acc.get(i).getAccPWD()){
				if (acc.get(i).getAccBal() < total){
					System.out.println ("계좌의 잔액이 부족합니다!");
					return 2001;
				}
				if (acc.get(i).getAccType() != 1){
					System.out.println("입출금계좌만 계좌간 거래가 가능합니다!");
					return 2002;
				}
				send = i;

				cnt ++;
			}
			if (sentAccNum.equals(acc.get(i).getAccNum())){
				cnt ++;
				sent = i;
			}
		}
		if (cnt == 2){
			acc.get(send).setAccBal(acc.get(send).getAccBal() - total);
			acc.get(sent).setAccBal(acc.get(sent).getAccBal() + total);
			System.out.printf("%s 고객의 %s 입출금 계좌의 잔액은 %d원 입니다! \n", acc.get(send).getAccUser(), acc.get(send).getAccNum(), acc.get(send).getAccBal());
			transaction.transLogReq(sendAccNum, acc.get(send).getAccUser(), date.toString(), "출금", -total, 0, 0, 0, 0, acc.get(send).getAccBal());
			transaction.transLogReq(sendAccNum, acc.get(sent).getAccUser(), date.toString(),"입금", total, 0, 0, 0, 0, acc.get(sent).getAccBal());
		}
		if (cnt != 2){
			System.out.println("입출금 거래 정보가 맞지 않습니다!");
			return 2004;
		}
		return 1000;
	}

	protected ArrayList depositSearch(String userId){//유저 계좌 조회 -> 가지고 있는 전체 계좌를 보여줌. 로그인 한 상태이고 무조건 1개 이상의 계좌가 있다고 가정. 오류처리 안함
		ArrayList<AccountInfo> depositSearching = new ArrayList<>();
		for (int j = 0; j < acc.size(); j++) {
			if (userId.equals(acc.get(j).getAccUser())) {
				if (acc.get(j).getAccType() == 1) {
					AccountInfo depositSearchs = new AccountInfo(acc.get(j).getAccUser(), acc.get(j).getAccNum(), acc.get(j).getAccBal(), acc.get(j).getAccType(), acc.get(j).getAccPWD());
					depositSearching.add(depositSearchs);
				}
				if (acc.get(j).getAccType() == 2) {
					AccountInfo depositSearchs = new AccountInfo(acc.get(j).getAccUser(), acc.get(j).getAccNum(), acc.get(j).getAccBal(), acc.get(j).getAccType(), acc.get(j).getAccPWD());
					depositSearching.add(depositSearchs);				}
				if (acc.get(j).getAccType() == 3) {
					AccountInfo depositSearchs = new AccountInfo(acc.get(j).getAccUser(), acc.get(j).getAccNum(), acc.get(j).getAccBal(), acc.get(j).getAccType(), acc.get(j).getAccPWD());
					depositSearching.add(depositSearchs);				}
			}
		}
		return depositSearching;
	}
}
