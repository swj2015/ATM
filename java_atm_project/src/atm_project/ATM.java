package atm_project;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
//
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
//

public class ATM extends JFrame {

    int leftManWon = 1000;            //만원권 남은 장수
    int left5ManWon = 200;           //5만원권 남은 장수
    int leftCheonWon = 0;            //천원권 남은 장수
    int left5CheonWon = 0;            //5천원권 남은 장수
    
    
    //
	private static String is_id;
	private static String is_PWD;
	private static int a = 0;	// admin or user
	private static int num = 0;	// admin 로그인 성공여부
	private static int num2 = 0;	// user 식별
	private static int adPWD;
	private static int n = 0; // 작업선택
	private static int vali;
	private static int vali2;
	private static int cnt2 = 0; // 작업선택

	//
	private static JFrame atmFr = new JFrame("ATM");
	private static JLabel Loginlabel = new JLabel("< ATM Login >");
	private static JLabel idlabel = new JLabel("ID : ");
	private static JLabel pwlabel = new JLabel("Password : ");
	private static JTextField LoginId = new JTextField("");
	private static JPasswordField LoginPw = new JPasswordField("");
	private static JButton okay = new JButton("로그인");
    
	//admin. 1 관리자 지폐 입금, 2 관리자 지폐 출금, 3 남은 지폐 확인, 4 Transaction Log 조회, 5 로그인 화면
	private static JFrame adFr = new JFrame("Admin Workpage");
	private static JLabel adlabel = new JLabel("< Admin Works >");
	private static JButton ad1 = new JButton("ATM 내부 지폐 충전");
	private static JButton ad2 = new JButton("ATM 내부 지폐 인출");
	private static JButton ad3 = new JButton("ATM 잔여 지폐량 확인");
	private static JButton ad4 = new JButton("Transaction Log 조회");
	private static JButton ad5 = new JButton("로그아웃");
	
	private static JFrame adF1 = new JFrame("Admin: 지폐 충전");
	private static JFrame adF2 = new JFrame("Admin: 지폐 인출");
	private static JFrame adF3 = new JFrame("Admin: 잔여지폐 확인");
	private static JFrame adF4 = new JFrame("Admin: Transaction Log");
		
		
		
	//user. 1을 누르면 입금, 2을 누르면 출금, 3을 누르면 계좌간 거래, 4를 계좌조회, 5를 누르면 로그인 화면으로
	private static JFrame userFr = new JFrame("User Workpage");
	private static JLabel userlabel = new JLabel("< User Works >");
	private static JButton user1 = new JButton("입금하기");
	private static JButton user2 = new JButton("출금하기");
	private static JButton user3 = new JButton("계좌간 거래(송금하기)");
	private static JButton user4 = new JButton("계좌 조회");
	private static JButton user5 = new JButton("로그아웃");
		
	private static JFrame userF1 = new JFrame("입금");
	private static JFrame userF2 = new JFrame("출금");
	private static JFrame userF3 = new JFrame("송금");
	private static JFrame userF4 = new JFrame("계좌 조회");
		
	private static int newcheonWon=0;
	private static int newohCheonWon =0;
	private static int newmanWon =0;
	private static int newohManWon=0;
		
	private static String accNum;
	private static int accPWD;
	private static int total;
	private static String sendAccNum;
	private static int sendAccPWD;
	private static String sentAccNum;
    
	private static int och;
	private static int fch;
	private static int om;
	private static int fm;
	
	
	
	
	
	
    
    void billAdd(int cheonWon, int ohCheonWon, int manWon, int ohManWon) {
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
    	
        
        
        
        
        Admin ad = new Admin(admin);
        User us = new User(user);
        Account ac = new Account(acc);
        Transaction trans = new Transaction();
        // ATMInfo atmInfos;

        
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

        AccountInfo newAcc1 = new AccountInfo("성우진", "111122223333", 1250000, 1, 1111);
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

        
        
                
    	// GUI
    	
    	JRadioButton adLogin = new JRadioButton("Admin Login");
    	JRadioButton userLogin = new JRadioButton("User Login");
    	userLogin.setSelected(true);
    	ButtonGroup group = new ButtonGroup();
    	
    	atmFr.setLayout(null);
    	atmFr.setSize(400,400);
    	atmFr.setLocationRelativeTo(null);
    	atmFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	atmFr.setVisible(true);
    	
    	group.add(adLogin);
    	group.add(userLogin);
    	
    	Loginlabel.setBounds(150, 20, 200, 30);
    	adLogin.setBounds(40,80,200,30);	// x,y,가로,세로
    	userLogin.setBounds(40,50,200,30);
    	idlabel.setBounds(70, 130, 60, 30);
    	pwlabel.setBounds(30, 170, 70, 30);
    	
    	LoginId.setBounds(110, 130, 200, 30);
    	LoginPw.setBounds(110,170, 200, 30);
    	okay.setBounds(70, 230, 250, 30);
    	
    	
    	atmFr.add(Loginlabel);
    	atmFr.add(adLogin);
    	atmFr.add(userLogin);
    	atmFr.add(idlabel);
    	atmFr.add(pwlabel);
    	atmFr.add(LoginId);
    	atmFr.add(LoginPw);
    	atmFr.add(okay);
    	
    	//////////////////////////
    	
    	
    	adFr.setLayout(null);
    	adFr.setSize(400,400);
    	adFr.setLocationRelativeTo(null);
    	adFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	adFr.setVisible(false);
    	
    	adlabel.setBounds(150, 20, 200, 30);
    	ad1.setBounds(80, 80, 220, 40);
    	ad2.setBounds(80, 130, 220, 40);
    	ad3.setBounds(80, 180, 220, 40);
    	ad4.setBounds(80, 230, 220, 40);
    	ad5.setBounds(80, 280, 220, 40);
    	
    	adFr.add(adlabel);
    	adFr.add(ad1); adFr.add(ad2); adFr.add(ad3); adFr.add(ad4); adFr.add(ad5);
    	
    	adF1.setLayout(null);
    	adF2.setLayout(null);
    	adF3.setLayout(null);
    	adF4.setLayout(null);
    	
    	adF1.setSize(400,400); adF1.setLocationRelativeTo(null);
    	adF2.setSize(400,400); adF2.setLocationRelativeTo(null);
    	adF3.setSize(400,400); adF3.setLocationRelativeTo(null);
    	adF4.setSize(400,400); adF4.setLocationRelativeTo(null);
    	
    	JButton ad1_ok = new JButton("완료");
    	JButton ad2_ok = new JButton("완료");
    	JButton ad3_ok = new JButton("확인");
    	JButton ad4_ok = new JButton("확인");
    	
    	
    	// 1번 지폐 충전
    	JLabel ad11 = new JLabel("입금하실 천원권 매수를 입력해주세요.");
    	JLabel ad12 = new JLabel("입금하실 오천원권 매수를 입력해주세요.");
    	JLabel ad13 = new JLabel("입금하실 만원권 매수를 입력해주세요.");
    	JLabel ad14 = new JLabel("입금하실 오만원권 매수를 입력해주세요.");
    	
    	JTextField add1c = new JTextField();
    	JTextField add5c = new JTextField();
    	JTextField add1m = new JTextField();
    	JTextField add5m = new JTextField();
    	
    	ad11.setBounds(50, 20, 300, 30);
    	add1c.setBounds(50, 50, 200, 30);
    	ad12.setBounds(50, 90, 300, 30);
    	add5c.setBounds(50, 120, 200, 30);
    	ad13.setBounds(50, 160, 300, 30);
    	add1m.setBounds(50, 190, 200, 30);
    	ad14.setBounds(50, 230, 300, 30);
    	add5m.setBounds(50, 260, 200, 30);
    	ad1_ok.setBounds(260, 310, 100, 30);
    	
    	adF1.add(ad11); adF1.add(ad12); adF1.add(ad13); adF1.add(ad14);
    	adF1.add(add1c); adF1.add(add5c); adF1.add(add1m); adF1.add(add5m);
    	adF1.add(ad1_ok);
    	
    	
    	// 2번 지폐인출
    	JLabel ad21 = new JLabel("출금하실 천원권 매수를 입력해주세요.");
    	JLabel ad22 = new JLabel("출금하실 오천원권 매수를 입력해주세요.");
    	JLabel ad23 = new JLabel("출금하실 만원권 매수를 입력해주세요.");
    	JLabel ad24 = new JLabel("출금하실 오만원권 매수를 입력해주세요.");
    	
    	JTextField out1c = new JTextField();
    	JTextField out5c = new JTextField();
    	JTextField out1m = new JTextField();
    	JTextField out5m = new JTextField();
    	
    	ad21.setBounds(50, 20, 300, 30);
    	out1c.setBounds(50, 50, 200, 30);
    	ad22.setBounds(50, 90, 300, 30);
    	out5c.setBounds(50, 120, 200, 30);
    	ad23.setBounds(50, 160, 300, 30);
    	out1m.setBounds(50, 190, 200, 30);
    	ad24.setBounds(50, 230, 300, 30);
    	out5m.setBounds(50, 260, 200, 30);
    	ad2_ok.setBounds(260, 310, 100, 30);
    	
    	adF2.add(ad21); adF2.add(ad22); adF2.add(ad23); adF2.add(ad24);
    	adF2.add(out1c); adF2.add(out5c); adF2.add(out1m); adF2.add(out5m);
    	adF2.add(ad2_ok);   	
    	
    	
    	
    	
    	
    	
    	// 4번 트랜젝션 로그 조회
    	// Account 클래스 수정해야함 -> ac.transLogSearch();
    	
    	
    	JLabel ad35 = new JLabel("트랜젝션 로그 조회 : ");
    	ad35.setBounds(50, 20, 300, 30);
    	adF4.add(ad35);
    	
    	
    	
    	ArrayList<Transaction_Log> Log;
        Log = ac.transLogSearch();
    	
		for (int i = 0; i< Log.size(); i++){
			
    		String st1 = Log.get(i).getTransAcc();	//계좌
        	String st2 = Log.get(i).getReqUserName();	//사용자 이름
        	String st3 = Log.get(i).getTransDate();		//거래시간
        	String st4 = Log.get(i).getTransType();	//거래종류
        	int in1 = Log.get(i).getTransTotal();	//입금금액
        	int in2 = Log.get(i).getTransManWon();
        	int in3 = Log.get(i).getTrans5ManWon();
        	int in4 = Log.get(i).getTransCheonWon();
        	int in5 = Log.get(i).getTrans5CheonWon();
        	int in6 = Log.get(i).getAccBal();
        	JLabel ad36 = new JLabel("계좌 : " + st1 + ", 사용자 이름 : "+ st2 + ", 거래시간 : "+ st3 + ", 거래종류 : " + st4);
        	JLabel ad37 = new JLabel("입금금액 : " + in1 + ", 만원권 : "+ in2 + ", 오만원권 : "+ in3 + " , 천원권 : " + in4 + " , 계좌잔액 : " + in5);

        	ad36.setBounds(50, 80+i*30, 300, 30);
        	adF4.add(ad36);
        	ad37.setBounds(50, 100+i*30, 300, 30);
        	adF4.add(ad37);
        	
    	}
    	
    	ad4_ok.setBounds(260, 310, 100, 30);
    	adF4.add(ad4_ok);
    	
 
    	
    	
    	// admin 작업완료 버튼
    	
    	ad1_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String new1c = add1c.getText();
		 		newcheonWon = Integer.parseInt(new1c);
		 		String new5c = add5c.getText();
		 		newohCheonWon = Integer.parseInt(new5c);
		 		String new1m = add1m.getText();
		 		newmanWon = Integer.parseInt(new1m);
		 		String new5m = add5m.getText();
		 		newohManWon = Integer.parseInt(new5m);
		 		
				atm.billAdd(newcheonWon,newohCheonWon,newmanWon,newohManWon);
				
				och = atm.leftCheonWon;
		    	fch = atm.left5CheonWon;
		    	om = atm.leftManWon;
		    	fm = atm.left5ManWon;
				
		    	System.out.println("ATM기 안에 남은 천원권 장 수는 : " + atm.leftCheonWon);
				System.out.println("ATM기 안에 남은 오천원권 장 수는 : " + atm.left5CheonWon);
				System.out.println("ATM기 안에 남은 만원권 장 수는 : " + atm.leftManWon);
				System.out.println("ATM기 안에 남은 오만원권 장 수는 : " + atm.left5ManWon);
		    	
				JOptionPane.showMessageDialog(null, "지폐가 정상적으로 충전되었습니다!");
				adF1.dispose();
				adFr.setVisible(true);
				//알림창
			}
			
 		});
    	
    	ad2_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 입력
				String new1c = out1c.getText();
		 		newcheonWon = Integer.parseInt(new1c);
		 		String new5c = out5c.getText();
		 		newohCheonWon = Integer.parseInt(new5c);
		 		String new1m = out1m.getText();
		 		newmanWon = Integer.parseInt(new1m);
		 		String new5m = out5m.getText();
		 		newohManWon = Integer.parseInt(new5m);
				
				
				if(atm.leftCheonWon < newcheonWon) {
					JOptionPane.showConfirmDialog(null, "천원권의 매수가 부족합니다.", "인출 실패(Admin)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	    		 }
				else if(atm.left5CheonWon < newohCheonWon) {
					JOptionPane.showConfirmDialog(null, "5천원권의 매수가 부족합니다.", "인출 실패(Admin)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				}
				else if(atm.leftManWon < newmanWon) {
					JOptionPane.showConfirmDialog(null, "만원권의 매수가 부족합니다.", "인출 실패(Admin)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				}
				else if(atm.left5ManWon < newohManWon) {
					JOptionPane.showConfirmDialog(null, "5만원권의 매수가 부족합니다.", "인출 실패(Admin)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				}
				else {
					atm.billAdd(-newcheonWon,-newohCheonWon,-newmanWon,-newohManWon);
	
					System.out.println("ATM기 안에 남은 천원권 장 수는 : " + atm.leftCheonWon);
					System.out.println("ATM기 안에 남은 오천원권 장 수는 : " + atm.left5CheonWon);
					System.out.println("ATM기 안에 남은 만원권 장 수는 : " + atm.leftManWon);
					System.out.println("ATM기 안에 남은 오만원권 장 수는 : " + atm.left5ManWon);
					
					JOptionPane.showMessageDialog(null, "지폐가 정상적으로 인출되었습니다!");
					
					
					adF2.dispose();
					adFr.setVisible(true);
					
				}
				
			}
 		});
    	
    	ad3_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adF3.dispose();
		    	adFr.setVisible(true);
			}
 		});
    	
    	ad4_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Account 클래스에서
				//ac.transLogSearch();
		    	
				
				
				adF4.dispose();
		    	adFr.setVisible(true);
				
			}
 		});
    	
    	///////////
    	
    	userFr.setLayout(null);
    	userFr.setSize(400,400);
    	userFr.setLocationRelativeTo(null);
    	userFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	userFr.setVisible(false);
    	
    	userlabel.setBounds(150, 20, 200, 30);
    	user1.setBounds(80, 80, 220, 40);
    	user2.setBounds(80, 130, 220, 40);
    	user3.setBounds(80, 180, 220, 40);
    	user4.setBounds(80, 230, 220, 40);
    	user5.setBounds(80, 280, 220, 40);
    	
    	userFr.add(userlabel);
    	userFr.add(user1); userFr.add(user2); userFr.add(user3); userFr.add(user4); userFr.add(user5);
    	
    	userF1.setLayout(null);
    	userF2.setLayout(null);
    	userF3.setLayout(null);
    	userF4.setLayout(null);
    	
    	userF1.setSize(400,400); userF1.setLocationRelativeTo(null);
    	userF2.setSize(400,400); userF2.setLocationRelativeTo(null);
    	userF3.setSize(400,400); userF3.setLocationRelativeTo(null);
    	userF4.setSize(400,400); userF4.setLocationRelativeTo(null);
    	
    	////////////////////////   	
    	JButton user1_ok = new JButton("완료");
    	JButton user2_ok = new JButton("완료");
    	JButton user3_ok = new JButton("완료");
    	JButton user4_ok = new JButton("확인");    	
    	
    	
    	// 1번 입금 - 계좌번호,비번,총금액,매수
    	
    	JLabel user11 = new JLabel("입금하실 계좌번호를 입력하세요.");
    	JLabel user12 = new JLabel("계좌 비밀번호를 입력하세요.");
    	JLabel user13 = new JLabel("총 금액을 입력하세요.");
    	JLabel user14 = new JLabel("입금하실 천원권 매수를 입력해주세요.");
    	JLabel user15 = new JLabel("입금하실 오천원권 매수를 입력해주세요.");
    	JLabel user16 = new JLabel("입금하실 만원권 매수를 입력해주세요.");
    	JLabel user17 = new JLabel("입금하실 오만원권 매수를 입력해주세요.");
    	
    	JTextField ua11 = new JTextField();
    	JPasswordField ua12 = new JPasswordField();
    	JTextField ua13 = new JTextField();
    	JTextField ua1c = new JTextField();
    	JTextField ua5c = new JTextField();
    	JTextField ua1m = new JTextField();
    	JTextField ua5m = new JTextField();
    	
    	user11.setBounds(50, 10, 300, 20);
    	ua11.setBounds(50, 30, 200, 20);
    	user12.setBounds(50, 50, 300, 20);
    	ua12.setBounds(50, 70, 200, 20);
    	user13.setBounds(50, 90, 300, 20);
    	ua13.setBounds(50, 110, 200, 20);
    	user14.setBounds(50, 130, 300, 20);
    	ua1c.setBounds(50, 150, 200, 20);
    	user15.setBounds(50, 170, 300, 20);
    	ua5c.setBounds(50, 190, 200, 20);
    	user16.setBounds(50, 210, 300, 20);
    	ua1m.setBounds(50, 230, 200, 20);
    	user17.setBounds(50, 250, 300, 20);
    	ua5m.setBounds(50, 270, 200, 20);
    	
    	user1_ok.setBounds(290, 310, 80, 30);
    	
    	userF1.add(user11); userF1.add(user12); userF1.add(user13); userF1.add(user14); userF1.add(user15); userF1.add(user16); userF1.add(user17);
    	userF1.add(ua11); userF1.add(ua12); userF1.add(ua13); userF1.add(ua1c); userF1.add(ua5c); userF1.add(ua1m); userF1.add(ua5m);
    	userF1.add(user1_ok);    	
    	
    	
    	
    	// 2번 출금
    	JLabel user21 = new JLabel("출금하실 계좌번호를 입력하세요.");
    	JLabel user22 = new JLabel("계좌 비밀번호를 입력하세요.");
    	JLabel user23 = new JLabel("총 금액을 입력하세요.");
    	JLabel user24 = new JLabel("출금하실 천원권 매수를 입력해주세요.");
    	JLabel user25 = new JLabel("출금하실 오천원권 매수를 입력해주세요.");
    	JLabel user26 = new JLabel("출금하실 만원권 매수를 입력해주세요.");
    	JLabel user27 = new JLabel("출금하실 오만원권 매수를 입력해주세요.");
    	
    	JTextField uo21 = new JTextField();
    	JPasswordField uo22 = new JPasswordField();
    	JTextField uo23 = new JTextField();
    	JTextField uo1c = new JTextField();
    	JTextField uo5c = new JTextField();
    	JTextField uo1m = new JTextField();
    	JTextField uo5m = new JTextField();
    	
    	user21.setBounds(50, 10, 300, 20);
    	uo21.setBounds(50, 30, 200, 20);
    	user22.setBounds(50, 50, 300, 20);
    	uo22.setBounds(50, 70, 200, 20);
    	user23.setBounds(50, 90, 300, 20);
    	uo23.setBounds(50, 110, 200, 20);
    	user24.setBounds(50, 130, 300, 20);
    	uo1c.setBounds(50, 150, 200, 20);
    	user25.setBounds(50, 170, 300, 20);
    	uo5c.setBounds(50, 190, 200, 20);
    	user26.setBounds(50, 210, 300, 20);
    	uo1m.setBounds(50, 230, 200, 20);
    	user27.setBounds(50, 250, 300, 20);
    	uo5m.setBounds(50, 270, 200, 20);
    	
    	user2_ok.setBounds(290, 310, 80, 30);
    	
    	userF2.add(user21); userF2.add(user22); userF2.add(user23); userF2.add(user24); userF2.add(user25); userF2.add(user26); userF2.add(user27);
    	userF2.add(uo21); userF2.add(uo22); userF2.add(uo23);
    	userF2.add(uo1c); userF2.add(uo5c); userF2.add(uo1m); userF2.add(uo5m);
    	userF2.add(user2_ok);   	
    	
    	
        // 3번 송금
    	
    	JLabel user31 = new JLabel("보내는 계좌의 계좌번호를 입력하세요.");
    	JLabel user32 = new JLabel("계좌 비밀번호를 입력하세요.");
    	JLabel user33 = new JLabel("받는 계좌의 계좌번호를 입력하세요.");
    	JLabel user34 = new JLabel("총 금액을 입력하세요.");
    	
    	JTextField us31 = new JTextField();
    	JPasswordField us32 = new JPasswordField();
    	JTextField us33 = new JTextField();
    	JTextField us34 = new JTextField();
    	
    	
    
    	user31.setBounds(50, 20, 300, 30);
    	us31.setBounds(50, 50, 200, 30);
    	user32.setBounds(50, 90, 300, 30);
    	us32.setBounds(50, 120, 200, 30);
    	user33.setBounds(50, 160, 300, 30);
    	us33.setBounds(50, 190, 200, 30);
    	user34.setBounds(50, 230, 300, 30);
    	us34.setBounds(50, 260, 200, 30);
    	user3_ok.setBounds(260, 310, 100, 30);
    	
    	userF3.add(user31); userF3.add(user32); userF3.add(user33); userF3.add(user34); 
    	userF3.add(us31); userF3.add(us32); userF3.add(us33); userF3.add(us34);
    	userF3.add(user3_ok);
    	
    	
    	
    	
    	
    	
    	
    	// 4번 계좌조회
    	
    	
    	// Account 클래스 -> ac.depositSearch(user.get(num2).getUserName());   
    	

    	

    	
    	
    	
    	
    	
    	
    	
    	// 작업완료 버튼
    	
    	
    	user1_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 입금
				String new11 = ua11.getText();
				accNum = new11;
				String new12 = ua12.getText();
				accPWD = Integer.parseInt(new12);
				String new13 = ua13.getText();
				total = Integer.parseInt(new13);
				String new1c = ua1c.getText();
		 		newcheonWon = Integer.parseInt(new1c);
		 		String new5c = ua5c.getText();
		 		newohCheonWon = Integer.parseInt(new5c);
		 		String new1m = ua1m.getText();
		 		newmanWon = Integer.parseInt(new1m);
		 		String new5m = ua5m.getText();
		 		newohManWon = Integer.parseInt(new5m);
		 		
		 		if ((1000 * newcheonWon + 5000 * newohCheonWon + 10000 * newmanWon + 50000 * newohManWon) == total){
					vali = ac.depositReq(accNum, accPWD, total, newcheonWon, newohCheonWon, newmanWon, newohManWon);
					if(vali == 1000) {
						atm.billAdd(newcheonWon,newohCheonWon,newmanWon,newohManWon);
						JOptionPane.showMessageDialog(null, "정상적으로 입금되었습니다!");
						
						userF1.dispose();
						userFr.setVisible(true);
					}
					else if(vali == 2000) {
						JOptionPane.showConfirmDialog(null, "알맞지 않은 계좌번호나 비밀번호입니다.", "입금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					}
				}
		 		else {
					JOptionPane.showConfirmDialog(null, "입금하시는 총 금액과 지폐 금액의 총합이 같아야 합니다.", "입금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				}
		 		
		 		// 작업선택화면으로
		 		
			}
 		});    	
    	
    	user2_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 출금
				String new11 = uo21.getText();
				accNum = new11;
				String new12 = uo22.getText();
				accPWD = Integer.parseInt(new12);
				String new13 = uo23.getText();
				total = Integer.parseInt(new13);
				String new1c = uo1c.getText();
		 		newcheonWon = Integer.parseInt(new1c);
		 		String new5c = uo5c.getText();
		 		newohCheonWon = Integer.parseInt(new5c);
		 		String new1m = uo1m.getText();
		 		newmanWon = Integer.parseInt(new1m);
		 		String new5m = uo5m.getText();
		 		newohManWon = Integer.parseInt(new5m);
				
		 		int a=0;
		 		
				if ((1000 * newcheonWon + 5000 * newohCheonWon + 10000 * newmanWon + 50000 * newohManWon) == total){
					if (atm.leftCheonWon < newcheonWon) { 
						a=1;
						JOptionPane.showConfirmDialog(null, "ATM 내에 천원권 지폐가 부족합니다.", "출금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); 
						}
					else if (atm.left5CheonWon < newohCheonWon) { 
						a=2;
						JOptionPane.showConfirmDialog(null, "ATM 내에 5천원권 지폐가 부족합니다.", "출금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); 
						}
					else if (atm.leftManWon < newmanWon) { 
						a=3;
						JOptionPane.showConfirmDialog(null, "ATM 내에 만원권 지폐가 부족합니다.", "출금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); 
						}
					else if (atm.left5ManWon < newohManWon) { 
						a=4;
						JOptionPane.showConfirmDialog(null, "ATM 내에 5만원권 지폐가 부족합니다.", "출금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); 
					}
					
					if(a<5) {
						if(a==0) {
							vali = ac.withdrawReq(accNum, accPWD, total, newcheonWon, newohCheonWon, newmanWon, newohManWon);
						}
							if(vali == 1000) {
								atm.billAdd(-newcheonWon,-newohCheonWon,-newmanWon,-newohManWon);
								JOptionPane.showMessageDialog(null, "정상적으로 출금되었습니다!");
								userF2.dispose();
						    	userFr.setVisible(true);
							}
							else if(vali == 2000) {
								JOptionPane.showConfirmDialog(null, "알맞지 않은 계좌번호나 비밀번호입니다.", "출금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
								
							}
							else if(vali == 2001) {
								JOptionPane.showConfirmDialog(null, "계좌 잔액이 부족합니다.", "출금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							}
							else if(vali == 2003) {
								JOptionPane.showConfirmDialog(null, "입출금계좌의 출금만 가능합니다.", "출금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							}
						
						
					}
				}
				else {
					JOptionPane.showConfirmDialog(null, "출금하실 총 금액과 지폐 금액의 총합이 같아야 합니다.", "출금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				}
			}
			
 		});
    	
    	
    	user3_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 송금
				
				String sendaccnum  = us31.getText();
				String sendaccpwd  = us32.getText();
				String sentaccnum = us33.getText();
				String total1 = us34.getText();
				sendAccNum = sendaccnum;
				sendAccPWD = Integer.parseInt(sendaccpwd);
				sentAccNum = sentaccnum;
				total = Integer.parseInt(total1);
				
				//int cnt2 = 0;
				int vail2 = ac.remitReq(sendAccNum, sendAccPWD, sentAccNum, total);
		    	
				
				for(int i=0 ; i<acc.size(); i++) {
					if(vail2 == 2003) {
						JOptionPane.showConfirmDialog(null, "입출금계좌로만 입금이 가능합니다!", "송금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						cnt2++;
					}
					if(vail2 == 2001) {
						JOptionPane.showConfirmDialog(null, "계좌의 잔액이 부족합니다!", "송금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						cnt2++;
					}
					if(vail2 == 2002) {
						JOptionPane.showConfirmDialog(null, "입출금계좌만 계좌간 거래가 가능합니다", "송금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						cnt2++;
					}
				}
				
				if(vail2 == 2004) {
					JOptionPane.showConfirmDialog(null, "송금 거래 정보가 맞지 않습니다", "송금 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				}else
					JOptionPane.showConfirmDialog(null, "송금에 성공하였습니다!", "송금 성공(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				
				
				
				
		    	
				
				userF3.dispose();
		    	userFr.setVisible(true);
				
			}
 		});
    	
    	user4_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 계좌조회
				
				
				//
				userF4.dispose();
		    	userFr.setVisible(true);
				
			}
 		});
    	
    	
    	
    	
    	
    	///////////////////////////////////////////////
        Scanner s = new Scanner(System.in);
		
		System.out.println("--- System : ATM 프로그램을 실행합니다. ---");
			
			
			
			adLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a = 1;
				}
			});
			
			userLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a = 2;
					System.out.println(a);
				}
			});
			
			okay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				
			   		is_id = LoginId.getText();
			  		is_PWD = LoginPw.getText();
		 			adPWD = Integer.parseInt(is_PWD);
					
					
		 			System.out.println(a);
		 			System.out.println(is_id);
		 			System.out.println(adPWD);
			
		 		if(a == 1) {
					
					num = ad.adminIdentification(is_id, adPWD);		// 관리자 로그인 성공 실패 메소드
					System.out.println(num);
						
					    if(num == 1000) {
					    	atmFr.dispose();
					    	adFr.setVisible(true);
					    }
					    else {
					    	JOptionPane.showConfirmDialog(null, "아이디나 비밀번호가 일치하지 않습니다.", "로그인 실패(Admin)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			    		}
				}
				
		 		
		 		ad1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						n = 1;
						adFr.dispose();
						adF1.setVisible(true);
					}
		 		});
		 		ad2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						n = 2;
						adFr.dispose();
						adF2.setVisible(true);
					}
		 		});
		 		ad3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						n = 3;
						
						och = atm.leftCheonWon;
				    	fch = atm.left5CheonWon;
				    	om = atm.leftManWon;
				    	fm = atm.left5ManWon;
						
				    	JLabel ad31 = new JLabel("ATM기 안에 남은 천원권 장 수는 : " + och);
				    	JLabel ad32 = new JLabel("ATM기 안에 남은 오천원권 장 수는 : " + fch);
				    	JLabel ad33 = new JLabel("ATM기 안에 남은 만원권 장 수는 : " + om);
				    	JLabel ad34 = new JLabel("ATM기 안에 남은 오만원권 장 수는 : " + fm);
				    	
				    	ad31.setBounds(50, 50, 300, 30);
				    	ad32.setBounds(50, 80, 300, 30);
				    	ad33.setBounds(50, 110, 300, 30);
				    	ad34.setBounds(50, 140, 300, 30);
				    	ad3_ok.setBounds(260, 310, 100, 30);
				    	
				    	adF3.add(ad31); adF3.add(ad32); adF3.add(ad33); adF3.add(ad34);
				    	adF3.add(ad3_ok);
				    	
						adFr.dispose();
						adF3.setVisible(true);
					}
		 		});
		 		ad4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						n = 4;
						
						
						
						
						adFr.dispose();
						adF4.setVisible(true);
					}
		 		});
		 		ad5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 로그아웃
						adFr.dispose();
						//LoginId = new JTextField("");
						//LoginPw = new JTextField(""); 외않되????????????
				    	atmFr.setVisible(true);
					}
		 		});
		 		
		 		
//						n = s.nextInt();
//
//						switch(n){
//		 		
//							case 4:
//                				ac.transLogSearch();
//          			    	break;
//						}
//
			

//				case 2:		
			//유저로 로그인
				
				if(a == 2) {
					num = us.userIdentification(is_id, adPWD);
					System.out.println(num);
					
					if(is_id.equals("test1")) {
						num2 = 0;
					}else if(is_id.equals("test2")) {
						num2 = 1;
					}else {
						num2 = 2;
					}
					
					//계좌조회
					if(num2==0) {
						ArrayList<AccountInfo> info;
				        info = ac.depositSearch(user.get(num2).getUserName());
			        	String str = acc.get(num2).getAccUser();
			            JLabel user37 = new JLabel("계좌 조회 결과 : " + str + "님");
			            user37.setBounds(50, 50, 300, 30);
			        	userF4.add(user37);
			        	
			        	String str1 = acc.get(0).getAccNum();
			            int int2 = acc.get(0).getAccBal();
			            int int3 = acc.get(0).getAccType();
			            JLabel user38 = new JLabel("계좌번호 : " + str1 + ", 잔액 : " + int2 + "원");
			            String str5= "";
			            if(int3==1) {
			            	str5 = "입출금 전용 계좌입니다.";
			            }
			            JLabel user39 = new JLabel("통장종류 : " + int3 + "	 	=> 		" + str5);
			            user38.setBounds(50, 80, 300, 30);
				        user39.setBounds(50, 110, 300, 30);
				        userF4.add(user38);
				        userF4.add(user39);
				
				    	user4_ok.setBounds(260, 310, 100, 30);
				    	userF4.add(user4_ok);
						
					}
					if(num2==1) {
						ArrayList<AccountInfo> info;
				        info = ac.depositSearch(user.get(1).getUserName());
				        
			        	String str = acc.get(num2).getAccUser();
			        	JLabel user37 = new JLabel("계좌 조회 결과 : " + str + "님");
				        user37.setBounds(50, 50, 300, 30);
				        userF4.add(user37);
				        for(int i=1; i<3; i++) {
				        	String str1 = acc.get(i).getAccNum();
				            int int2 = acc.get(i).getAccBal();
				            int int3 = acc.get(i).getAccType();
				            JLabel user38 = new JLabel("계좌번호 : " + str1 + ", 잔액 : " + int2 + "원");
				            String str5= "";
				            if(int3==1) {
				            	str5 = "입출금 전용 계좌입니다.";
				            }else if(int3==2){
				            	str5 = "정기적금 계좌입니다.";
				            }else if(int3==3){
				            	str5 = "정기예금 계좌입니다.";
				            }
				            JLabel user39 = new JLabel("통장종류 : " + int3 + "	 	=> 		" + str5);
				            user38.setBounds(50, 80+(i-1)*60, 300, 30);
					        user39.setBounds(50, 110+(i-1)*60, 300, 30);
					        userF4.add(user38);
					        userF4.add(user39);
					
				        }
				        user4_ok.setBounds(260, 310, 100, 30);
				    	userF4.add(user4_ok);
			            
						
					}
					if(num2==2) {
						ArrayList<AccountInfo> info;
				        info = ac.depositSearch(user.get(2).getUserName());
				        
			        	String str = acc.get(3).getAccUser();
			        	JLabel user37 = new JLabel("계좌 조회 결과 : " + str + "님");
				        user37.setBounds(50, 50, 300, 30);
				        userF4.add(user37);
				        for(int i=3; i<6; i++) {
				        	String str1 = acc.get(i).getAccNum();
				            int int2 = acc.get(i).getAccBal();
				            int int3 = acc.get(i).getAccType();
				            JLabel user38 = new JLabel("계좌번호 : " + str1 + ", 잔액 : " + int2 + "원");
				            String str5= "";
				            if(int3==1) {
				            	str5 = "입출금 전용 계좌입니다.";
				            }else if(int3==2){
				            	str5 = "정기적금 계좌입니다.";
				            }else if(int3==3){
				            	str5 = "정기예금 계좌입니다.";
				            }
				            JLabel user39 = new JLabel("통장종류 : " + int3 + "	 	=> 		" + str5);
				            user38.setBounds(50, 80+(i-3)*60, 300, 30);
					        user39.setBounds(50, 110+(i-3)*60, 300, 30);
					        userF4.add(user38);
					        userF4.add(user39);
					
				        }
				        user4_ok.setBounds(260, 310, 100, 30);
				    	userF4.add(user4_ok);
						
					}
			    	
					
					
					
					
					
					
					if(num == 1000){
						System.out.println("> 1을 누르면 입금, 2을 누르면 출금, 3을 누르면 계좌간 거래, 4를 계좌조회, 5를 누르면 로그인 화면으로 돌아갑니다.");
						atmFr.dispose();
						userFr.setVisible(true);
					}
					else if(num == 2000) {
						// 로그인 실패 시
						JOptionPane.showConfirmDialog(null, "아이디나 비밀번호가 일치하지 않습니다.", "로그인 실패(User)", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					}
					
				}
//					
				user1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						n = 1;
						userFr.dispose();
						userF1.setVisible(true);
					}
		 		});
		 		user2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						n = 2;
						userFr.dispose();
						userF2.setVisible(true);
					}
		 		});
		 		user3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						n = 3;
						userFr.dispose();
						userF3.setVisible(true);
					}
		 		});
		 		user4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						n = 4;
						userFr.dispose();
						userF4.setVisible(true);
					}
		 		});
		 		user5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 로그아웃
						userFr.dispose();
				    	atmFr.setVisible(true);
				    	
					}
		 		});
				}
			});
    }

}
            
            
            
