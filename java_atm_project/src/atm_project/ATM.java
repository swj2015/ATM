package atm_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM{
    public static void main(String[] args) {


    	ArrayList<AdminInfo> admin = new ArrayList<>();
        ArrayList<UserInfo> user = new ArrayList<>();
        ArrayList<AccountInfo> acc = new ArrayList<>();

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
        ATMInfo atmInfo;
        Scanner s = new Scanner(System.in);

		int cheonWon=0;
		int ohCheonWon =0;
		int manWon =0;
		int ohManWon=0;

		System.out.println("--- System : ATM 프로그램을 실행합니다. ---\n");

		while(true){

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

					if(num == 1000){
						System.out.println("> 1을 누르면 관리자 지폐 입금을, 2을 누르면 관리자 지폐 출금, , 3을 누르면 ATM내 남은 지폐 확인, 4를 누르면 로그인화면으로 돌아갑니다.\n");
					}else if(num == 2000) {
						// 로그인 실패 시
						System.out.println("--- System : 초기 화면으로 돌아갑니다. ---");
						continue;
					}
					int n = s.nextInt();


					switch(n){

						case 1:
							System.out.print("지폐 입금을 시작합니다.\n");

							//입금할 지폐 장수 입력
							System.out.print("순서대로 지폐의 장수를 입력해주세요.\n 천원권: \n 오천원권: \n 만원권: \n 오만원권: \n");
							cheonWon = s.nextInt();
							ohCheonWon = s.nextInt();
							manWon = s.nextInt();
							ohManWon = s.nextInt();

							ad.adminBillAdd(cheonWon,ohCheonWon,manWon,ohManWon);

							break;
						case 2:
							System.out.print("관리자 지폐 출금을 시작합니다.\n");

							ad.adminBillTake(cheonWon,ohCheonWon,manWon,ohManWon);
							break;
						case 3:
							trans.getATMLeft();
							break;
						case 4:
							break;
					}

					break;



				case 2:																			//유저로 로그인
					System.out.print("고객 아이디를 입력해주세요\n");
					String str = s.next();

					System.out.println("비밀번호를 입력해주세요");
					int PWD = s.nextInt();

					int num1 = us.userIdentification(str,PWD);		//고객 로그인 성공 실패 메소드

					if(num1 == 1000){
						System.out.println("> 1을 누르면 입금, 2을 누르면 출금, 3을 누르면 계좌간 거래, 4를 계좌조회, 5를 누르면 로그인 화면으로 돌아갑니다. \n");
					}else if(num1 == 2000) {
						// 로그인 실패 시
						System.out.println("--- System : 초기 화면으로 돌아갑니다. ---");
						continue;
					}

					int a1 = s.nextInt();

					switch(a1){

						case 1:
							System.out.print("입금을 시작합니다. 입금할 금액을 입력해주세요.\n");

							cheonWon = s.nextInt();
							ohCheonWon = s.nextInt();
							manWon = s.nextInt();
							ohManWon = s.nextInt();

							ac.depositReq(acc.get(0).getAccNum(), acc.get(0).getAccPWD(), acc.get(0).getAccBal(), cheonWon, ohCheonWon, manWon, ohManWon);
							break;
						case 2:
							System.out.print("출금을 시작합니다. 출금할 금액을 입력해주세요.\n");
							int withdraw = s.nextInt();
							ac.withdrawReq(acc.get(0).getAccNum(), acc.get(0).getAccPWD(), acc.get(0).getAccBal(), cheonWon, ohCheonWon, manWon, ohManWon);
							break;
						case 3:
							System.out.print("계좌간 거래를 시작합니다");
							//ac.remitReq();
							break;
						case 4:
							System.out.print("계좌 조회를 시작합니다");
							us.depositSearch(str);						//처음 입력받은 고객 아이디에 해당하는 계좌 조회
							break;
						case 5:
							break;
					}
					break;
			}

		}
	}
}