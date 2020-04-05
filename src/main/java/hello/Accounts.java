package hello;

public class Accounts {

    private final String userAccount;
    private final String SAPLogin;

    public Accounts(String userAccount, String SAPLogin) {
        this.userAccount = userAccount;
        this.SAPLogin = SAPLogin;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public String getSAPLogin() {
        return SAPLogin;
    }
}