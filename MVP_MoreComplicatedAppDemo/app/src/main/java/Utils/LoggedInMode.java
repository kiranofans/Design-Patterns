package Utils;

public enum LoggedInMode {
    LOGGED_IN_MODE_LOGGOUT(0),
    LOGGED_IN_MODE_GMAIL(1),
    LOGGED_IN_MODE_FACEBOOK(2),
    LOGGED_IN_MODE_SERVER(3);

    private final int mLoggedInType;

    LoggedInMode(int type){
        mLoggedInType = type;
    }

    public int getType(){
        return mLoggedInType;
    }
}
