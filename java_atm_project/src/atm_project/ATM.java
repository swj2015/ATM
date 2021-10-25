package atm_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM{

	int leftManWon = 1000;            //만원권 남은 장수
	int left5ManWon = 200;           //5만원권 남은 장수
	int leftCheonWon = 0;            //천원권 남은 장수
	int left5CheonWon = 0;            //5천원권 남은 장수

	void billAdd(int cheonWon, int ohCheonWon, int manWon, int ohManWon){
		leftManWon += manWon;
		left5ManWon += ohManWon;
		leftCheonWon += cheonWon;
		left5CheonWon += ohCheonWon;
	}

    public static void main(String[] args) {

		ATM atm = new ATM();

    	ArrayList<AdminInfo> admin = new ArrayList<>();
        ArrayList<UserInfo> user = new ArrayList<>();
        ArrayList<AccountInfo> acc = new ArrayList<>();
        ArrayList<ATMInfo> atmInfo = new ArrayList<>();

        ATMInfo newATM = new ATMInfo(1000, 200, 0 ,0);
        atmInfo.add(newATM);

        UserInfo newUser1 = new UserInfo("성우진", "test1", 1123, 1, "111122223333", null, null);
        user.add(newUser1);
        UserInfo newUser2 = new UserInfo("최준혁", "test2", 2449, 2, "123456789012", "123412341234", null);
        user.add(newUser2);
        UserInfo newUser3 = new UserInfo("정수현", "test3", 6631, 3, "999988887777", "666655554444", "333322221111");
        user.add(newUser3);

        AdminInfo newAdmin1 = new AdminInfo("admin1", 1234, "관리자1");
        admin.add(newAdmin1);
        AdminInfo newAdmin2 = new AdminInfo("admin2", 5678, "관리자2");
        admin.add(newAdmin2);

        AccountInfo newAcc1 = new AccountInfo("성우진", "111122223333", 1250000, 1,1111);
        acc.add(newAcc1);
        AccountInfo newAcc2 = new AccountInfo("최준혁", "123456789012", 3800000, 1, 1111);
        acc.add(newAcc2);
        AccountInfo newAcc3 = new AccountInfo("최준혁", "123412341234", 5000000, 2, 2222);
        acc.add(newAcc3);
        AccountInfo newAcc4 = new AccountInfo("정수현", "999988887777", 1800000, 1, 1111);
        acc.add(newAcc4);
        AccountInfo newAcc5 = new AccountInfo("정수현", "666655554444", 800000, 2, 2222);
        acc.add(newAcc5);
        AccountInfo newAcc6 = new AccountInfo("정수현", "333322221111", 240000, 3, 3333);
        acc.add(newAcc6);

        Admin ad = new Admin(admin);
        User us = new User(user);
        Account ac = new Account(acc);
        Transaction trans = new Transaction();
//        ATMInfo atmInfos;
        Scanner s = new Scanner(System.in);

		int newcheonWon=0;
		int newohCheonWon =0;
		int newmanWon =0;
		int newohManWon=0;

		String accNum;
		int accPWD;
		int total;
		String sendAccNum;
		int sendAccPWD;
		String sentAccNum;

		System.out.println("--- System : ATM 프로그램을 실행합니다. ---");

		while(true){
			System.out.println("[ 로그인 ]");
			int n = 0;

			System.out.println("관리자는 1번, 고객은 2번을 입력해주세요");
			int a = s.nextInt();
			if(a!=1 && a!=2) {
				continue;
			}
			switch(a){
				case 1:																			//관리자로 로그인
					System.out.print("관리자 아이디를 입력해주세요\n");
					String ad_id;
					ad_id = s.next();

					System.out.println("비밀번호를 입력해주세요");
					int ad_PWD;
					ad_PWD = s.nextInt();

					int num = ad.adminIdentification(ad_id,ad_PWD);		//관리자 로그인 성공 실패 메소드



					while(n != 4) {


						if(num == 1000){

							System.out.println("> 1을 누르면 관리자 지폐 입금을, 2을 누르면 관리자 지폐 출금, 3을 누르면 ATM내 남은 지폐 확인, 4를 누르면 로그인화면으로 돌아갑니다.");
						}else if(num == 2000) {
							// 로그인 실패 시
							System.out.println("--- System : 로그인 오류. 로그인 화면으로 돌아갑니다. ---");
							break;
						}
						n = s.nextInt();


						switch(n){

							case 1:
								System.out.print("지폐 입금을 시작합니다.\n");

								//입금할 지폐 장수 입력
								System.out.print("입금하실 천원권을 입력해주세요.\n");
								newcheonWon = s.nextInt();
								System.out.print("입금하실 오천원권을 입력해주세요.\n");
								newohCheonWon = s.nextInt();
								System.out.print("입금하실 만원권을 입력해주세요.\n");
								newmanWon = s.nextInt();
								System.out.print("입금하실 오만원권을 입력해주세요.\n");
								newohManWon = s.nextInt();

								atm.billAdd(newcheonWon,newohCheonWon,newmanWon,newohManWon);

								break;
							case 2:
								System.out.print("지폐 출금을 시작합니다.\n");
								System.out.print("출금하실 천원권을 입력해주세요.\n");
								newcheonWon = s.nextInt();
								System.out.print("출금하실 오천원권을 입력해주세요.\n");
								newohCheonWon = s.nextInt();
								System.out.print("출금하실 만원권을 입력해주세요.\n");
								newmanWon = s.nextInt();
								System.out.print("출금하실 오만원권을 입력해주세요.\n");
								newohManWon = s.nextInt();
								//ad.adminBillTake(cheonWon,ohCheonWon,manWon,ohManWon);
								break;
							case 3:
								trans.getATMLeft();
								break;
							case 4:

								System.out.println("--- System : 로그아웃 성공 ---");
								break;

						}


					}
					continue;


				case 2:																			//유저로 로그인
					System.out.print("고객 아이디를 입력해주세요\n");
					String str = s.next();

					System.out.println("비밀번호를 입력해주세요");
					int PWD = s.nextInt();
					int num2=0;
					int num1 = us.userIdentification(str,PWD);		//고객 로그인 성공 실패 메소드
					if(str.equals("test1")) {
						num2 = 0;
					}else if(str.equals("test2")) {
						num2 = 1;
					}else {
						num2 = 2;
					}

					while(n != 5) {
						if(num1 == 1000){
							System.out.println("> 1을 누르면 입금, 2을 누르면 출금, 3을 누르면 계좌간 거래, 4를 계좌조회, 5를 누르면 로그인 화면으로 돌아갑니다. \n");
						}else if(num1 == 2000) {
							// 로그인 실패 시
							System.out.println("--- System : 로그인 오류. 로그인 화면으로 돌아갑니다. ---");
							break;
						}

						n = s.nextInt();

						switch(n){

							case 1:
								System.out.print("입금을 시작합니다.\n");

								System.out.print("입금 계좌를 입력해주세요.\n");
								accNum = s.next();
								System.out.print("계좌 비밀번호를 입력해주세요.\n");
								accPWD = s.nextInt();
								System.out.print("총 금액을 입력해주세요.\n");
								total = s.nextInt();
								System.out.print("입금하실 천원권 장 수를 입력해주세요.\n");
								newcheonWon = s.nextInt();
								System.out.print("입금하실 오천원권 장 수를 입력해주세요.\n");
								newohCheonWon = s.nextInt();
								System.out.print("입금하실 만원권 장 수를 입력해주세요.\n");
								newmanWon = s.nextInt();
								System.out.print("입금하실 오만원권 장 수를 입력해주세요.\n");
								newohManWon = s.nextInt();


								//ac.depositReq(accNum, accPWD, total, cheonWon, ohCheonWon, manWon, ohManWon);
								break;
							case 2:
								System.out.print("출금을 시작합니다.\n");
								System.out.print("출금 계좌를 입력해주세요.\n");
								accNum = s.next();
								System.out.print("계좌 비밀번호를 입력해주세요.\n");
								accPWD = s.nextInt();
								System.out.print("총 금액을 입력해주세요.\n");
								total = s.nextInt();
								System.out.print("출금하실 천원권 장 수를 입력해주세요.\n");
								newcheonWon = s.nextInt();
								System.out.print("출금하실 오천원권 장 수를 입력해주세요.\n");
								newohCheonWon = s.nextInt();
								System.out.print("출금하실 만원권 장 수를 입력해주세요.\n");
								newmanWon = s.nextInt();
								System.out.print("출금하실 오만원권 장 수를 입력해주세요.\n");
								newohManWon = s.nextInt();
								//ac.withdrawReq(accNum, accPWD, total, cheonWon, ohCheonWon, manWon, ohManWon);
								break;
							case 3:
								System.out.print("계좌간 거래를 시작합니다.\n");
								System.out.print("보내는 계좌번호를 입력해주세요.\n");

								sendAccNum = s.next();
								System.out.print("계좌 비밀번호를 입력해주세요.\n");

								sendAccPWD = s.nextInt();
								System.out.print("받는 계좌번호를 입력해주세요.\n");

								sentAccNum = s.next();
								System.out.print("보낼 총금액을 입력해주세요.\n");

								total = s.nextInt();

								ac.remitReq(sendAccNum,sendAccPWD,sentAccNum,total);
								break;
							case 4:
								System.out.print("계좌 조회를 시작합니다.\n");
								ac.depositSearch(user.get(num2).getUserName());						//처음 입력받은 고객이름에 해당하는 계좌 조회
								break;
							case 5:
								System.out.println("--- System : 로그아웃 성공 ---");
								break;
						}
					}
			}
		}
	}
}