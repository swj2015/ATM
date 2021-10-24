package atm_project;

import java.util.ArrayList;
import java.util.List;

class ATMInfo {
    protected int leftManWon = 1000;            //만원권 남은 장수
    protected int left5ManWon = 200;           //5만원권 남은 장수
    protected int leftCheonWon = 0;            //천원권 남은 장수
    protected int left5CheonWon = 0;            //5천원권 남은 장수

    //protected List<String> atmPreInfo = new ArrayList<>();        //ATM 거래 이전 정보를 저장

//    protected void transactionReq() {            //거래요청
//    } //필요 없을듯...?

    protected int getLeftManWon() {return leftManWon;}          //ATM 전체 남은 만원권 장수 반환
    protected int getLeft5ManWon() {return left5ManWon;}          //ATM 전체 남은 5만원권 장수 반환
    protected int getLeftCheonWon() {return leftCheonWon;}           //ATM 전체 남은 천원권 장수 반환
    protected int getLeft5CheonWon() {return left5CheonWon;}           //ATM 전체 남은 5천원권 장수 반환
    protected void setManWon(int leftManWon) {this.leftManWon = leftManWon;} //ATM 전체 남은 만원권 장수 변경
    protected void set5ManWon(int left5ManWon) {this.left5ManWon = left5ManWon;} //ATM 전체 남은 5만원권 장수 변경
    protected void setCheonWon(int leftCheonWon) {this.leftCheonWon = leftCheonWon;} //ATM 전체 남은 천원권 장수 변경
    protected void set5CheonWon(int left5CheonWon) {this.left5CheonWon = left5CheonWon;} //ATM 전체 남은 5첝원권 장수 변경

    protected ATMInfo(int leftManWon, int left5ManWon, int leftCheonWon, int left5CheonWon) {
        this.leftManWon = leftManWon;
        this.left5ManWon = left5ManWon;
        this.leftCheonWon = leftCheonWon;
        this.left5CheonWon = left5CheonWon;
    } //ATM 기존 정보 저장에 사용
}
