package GameSQL;

public class GameUser {
    //필드
    private String gId;
    private String gPw;
    private String gName;
    private int gTier;
    private int GEXP;
    private int money;

    //생성자
    public GameUser() { }

    //메소드
    //getter and setter
    public String getgId() {
        return gId;
    }
    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgPw() {
        return gPw;
    }
    public void setgPw(String gPw) {
        this.gPw = gPw;
    }

    public String getgName() {
        return gName;
    }
    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getgTier() {
        return gTier;
    }
    public void setgTier(int gTier) {
        this.gTier = gTier;
    }

    public int getGEXP() {
        return GEXP;
    }
    public void setGEXP(int GEXP) {
        this.GEXP = GEXP;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
}