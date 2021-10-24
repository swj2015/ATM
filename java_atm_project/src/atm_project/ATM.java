package atm_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM{
    public static void main(String[] args) {
    	
    	
    	List<AdminInfo> admin = new ArrayList();
        List<User> user = new ArrayList();
        List<Account> acc = new ArrayList();
        
        User newUser1 = new User("성우진", "test1", 0000, 1, "111122223333", null, null);
        user.add(newUser1);
        User newUser2 = new User("최준혁", "test2", 2449, 2, "123456789012", "123412341234", null);
        user.add(newUser2);
        User newUser3 = new User("정수현", "test3", 6631, 3, "999988887777", "666655554444", "333322221111");
        user.add(newUser3);
        
        AdminInfo newAdmin1 = new AdminInfo("admin1", 1234, "관리자1");
        admin.add(newAdmin1);
        AdminInfo newAdmin2 = new AdminInfo("admin2", 5678, "관리자2");
        admin.add(newAdmin2);
        
        Account newAcc1 = new Account("성우진", "111122223333", 1250000, 1,1111);
        acc.add(newAcc1);
        Account newAcc2 = new Account("최준혁", "123456789012", 3800000, 1, 1111);
        acc.add(newAcc2);
        Account newAcc3 = new Account("최준혁", "123412341234", 5000000, 2, 2222);
        acc.add(newAcc3);
        Account newAcc4 = new Account("정수현", "999988887777", 1800000, 1, 1111);
        acc.add(newAcc4);
        Account newAcc5 = new Account("정수현", "666655554444", 800000, 2, 2222);
        acc.add(newAcc5);
        Account newAcc6 = new Account("정수현", "333322221111", 240000, 3, 3333);
        acc.add(newAcc6);
        
        
        Admin ad = new Admin();
        User us =new User(null, null, 0, 0, null, null, null);
        Scanner s = new Scanner(System.in);
   
        while(true){
		System.out.println("관리자는 1번, 고객은 2번을 입력해주세요");
		int a = s.nextInt();
	
		switch(a){
		case 1:																			//관리자로 로그인
				System.out.print("관리자 아이디를 입력해주세요\n");
				String ad_id;
				ad_id = s.next();
				
				System.out.println("비밀번호를 입력해주세요");
				int ad_PWD;
				ad_PWD = s.nextInt();
				
				ad.adminIdentification(ad_id,ad_PWD);									//관리자 로그인 성공 실패 메소드
				
				System.out.println("1을 누르면 관리자 지폐 입금을, 2을 누르면 관리자 지폐 출금, 3을 누르면 exit 합니다.\n");		
				int n = s.nextInt();
				
				
				
				switch(n){
					
				case 1:
						System.out.print("관리자 지폐 입금을 시작합니다");
						
						int cheonWon = s.nextInt();		//입금할 지폐 장수 입력
						int ohCheonWon = s.nextInt();
						int manWon = s.nextInt();
						int ohManWon = s.nextInt();
						
						ad.adminBillAdd(cheonWon,ohCheonWon,manWon,ohManWon);
						
						break;
				case 2:	
						System.out.print("관리자 지폐 출금을 시작합니다");
						
						//ad.adminBillTake(cheonWon,ohCheonWon,manWon,ohManWon);
						break;
				case 3:	
						System.exit(0);
				}
				
				break;
					
			
				
		case 2:																			//유저로 로그인
				System.out.print("고객 아이디를 입력해주세요\n");
				String str = s.next();	
				
				System.out.println("비밀번호를 입력해주세요\n");
				int PWD = s.nextInt();		
				
				us.userIdentification(str,PWD);
				
				System.out.println("1을 누르면 입금, 2을 누르면 출금, 3을 누르면 계좌간 거래, 4를 누르면 계좌 조회, 5를 누르면 exit");	
				
				int a1 = s.nextInt();
	
				switch(a1){
				
				case 1:
						System.out.print("입금을 시작합니다. 입금할 금액을 입력해주세요.\n");
						
						int deposit1 = s.nextInt();		//입금할 지폐 장수 입력
						int deposit2 = s.nextInt();
						int deposit3 = s.nextInt();
						int deposit4 = s.nextInt();
						
						//ac.depositReq(acc.get(0).getAccNum(), acc.get(0).getAccPWD(), acc.get(0).getAccBal(), deposit1, deposit2, deposit3, deposit4);
						break;
				case 2:	
						System.out.print("출금을 시작합니다. 출금할 금액을 입력해주세요.\n");
						int withdraw = s.nextInt();
						//ac.withdrawReq(acc.get(0).getAccNum(), acc.get(0).getAccPWD(), acc.get(0).getAccBal(), cheonWon, ohCheonWon, manWon, ohManWon);
						break;
				case 3:
						System.out.print("계좌간 거래를 시작합니다");
						//ac.remitReq();
						break;
				case 4:	
						System.out.print("계좌 조회를 시작합니다");
						//us.depositSearch(str);						//처음 입력받은 고객 아이디에 해당하는 계좌 조회
						break;
				case 5:	
						System.exit(0);
							
				}
				break;
			}

        	}
    }
}
