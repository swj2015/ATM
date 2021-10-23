package atm_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM{
    public static void main(String[] args) {

        List<User> user = new ArrayList<>();
        User newUser1 = new User("성우진", "test1", 0000, 1, "111122223333", null, null);
        user.add(newUser1);
        User newUser2 = new User("최준혁", "test2", 2449, 2, "123456789012", "123412341234", null);
        user.add(newUser2);
        User newUser3 = new User("정수현", "test3", 6631, 3, "999988887777", "666655554444", "333322221111");
        user.add(newUser3);

        System.out.println(user);
        
        Scanner s = new Scanner(System.in);
		
        while(true) 
        {
		System.out.println("관리자는 1번, 고객은 2번을 입력해주세요");
		
		int a = s.nextInt();
		switch(a){
		
		case 1:
				
				System.out.print("관리자 아이디를 입력해주세요\n");
				int ad_id = s.nextInt();
				
				System.out.println("비밀번호를 입력해주세요\n");
				int ad_PWD = s.nextInt();

				
				if(ad_id==12345 && ad_PWD == 1234) {					//관리자 로그인 성공
					System.out.println("로그인에 성공하였습니다.\n");
					System.out.println("1을 누르면 관리자 지폐 입금을, 2을 누르면 관리자 지폐 출금, 3을 누르면 exit 합니다.\n");		
					
					int n = s.nextInt();
					switch(n){
					
					case 1:
							System.out.print("관리자 지폐 입금을 시작합니다");
							//관리자 지폐 입금 메소드
							break;
					case 2:	
							System.out.print("관리자 지폐 출금을 시작합니다");
							//관리자 지폐 출금 메소드
							break;
					case 3:	
							//
							break;
					}
					
					
				}else System.out.println("잘못된 아이디나 비밀번호입니다.");
				break;
				
		case 2:	
				System.out.print("고객 아이디를 입력해주세요\n");
				String str = s.next();	//test1
				
				System.out.println("비밀번호를 입력해주세요\n");
				int PWD = s.nextInt();		//0000
				
				
				if( str.equals(user.get(0).getUserId()) && PWD == user.get(0).getUserPWD()) {
					System.out.println(user.get(0).getUserName() + "님 로그인에 성공하였습니다.\n");
					System.out.println("1을 누르면 입금, 2을 누르면 출금, 3을 누르면 계좌간 거래, 4를 누르면 계좌 조회, 5를 누르면 exit");	
					
					int n = s.nextInt();
					int deposit, withdraw;

					Account ac = new Account();		//account안에 있는 depositReq, withdrawReq 를 쓰기 위해 선언
					
					
					switch(n){
					
					case 1:
							System.out.print("입금을 시작합니다. 입금할 금액을 입력해주세요.\n");
							deposit = s.nextInt();
							ac.depositReq();
							break;
					case 2:	
							System.out.print("출금을 시작합니다. 출금할 금액을 입력해주세요.\n");
							withdraw = s.nextInt();
							ac.withdrawReq();
							break;
					case 3:
							System.out.print("계좌간 거래를 시작합니다");
							//
							break;
					case 4:	
							System.out.print("계좌 조회를 시작합니다");
							
							break;
					case 5:	
							//
							System.exit(0);
					}
				}else System.out.println("잘못된 아이디나 비밀번호입니다.");
				break;
			}

        
        
        }
    }
}
