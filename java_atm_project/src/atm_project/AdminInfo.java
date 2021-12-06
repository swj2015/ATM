package atm_project;

class AdminInfo {
    protected String adminId;		//관리자 아이디
    protected int adminPWD;			//관리자 비밀번호
    protected String adminName;		//관리자 이름

    protected String getAdminName() { return adminName; }
    protected int getAdminPWD() { return adminPWD; }
    protected String getAdminId() { return adminId; }

    protected AdminInfo (String adminId, int adminPWD, String adminName){
        this.adminId = adminId;
        this.adminPWD = adminPWD;
        this.adminName = adminName;
    }
}
