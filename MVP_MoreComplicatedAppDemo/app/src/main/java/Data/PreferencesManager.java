package Data;

import android.content.Context;
import android.content.SharedPreferences;

import AppModule.PreferencesHelper;
import Utils.LoggedInMode;
import component.ApplicationContext;
import component.PreferenceInfo;

public class PreferencesManager implements PreferencesHelper {
    //SharedPreferences
    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_LOGGED_IN_MODE";
    private static final String PREF_KEY_USER_ID = "PREF_KEY_USER_ID";
    private static final String PREF_KEY_USER_MOBILE = "PREF_KEY_CURRENT_MOBILE";
    private static final String PREF_KEY_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private static final String PREF_KEY_FIRST_TIME = "PREF_KEY_FIRST_TIME";
    private static final String PREF_KEY_USER_PROFILE_PIC_URL = "PREF_KEY_USER_PROFILE_PIC_URL";
    private static final String PREF_KEY_COACH_MARK = "PREF_KEY_COACH_MARK";

    private final SharedPreferences prefs;
    private Context appContext;

    public PreferencesManager(@ApplicationContext Context context,
                              @PreferenceInfo String prefsFileName) {
        this.prefs = context.getSharedPreferences(prefsFileName, Context.MODE_PRIVATE);
        appContext = context;
    }

    @Override
    public int getUserLoggedInMode() {
        return 0;
    }

    @Override
    public void setUserLoggedIn(LoggedInMode mode) {

    }

    @Override
    public Long getUserId() {
        return null;
    }

    @Override
    public void setUserId(Long userId) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public String getUserEmail() {
        return null;
    }

    @Override
    public void setUserEmail(String email) {

    }

    @Override
    public String getUserProfilePicUrl() {
        return null;
    }

    @Override
    public void setUserProfilePicUrl(String profilePicUrl) {

    }

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void setAccessToken(String accessToken) {

    }

    @Override
    public String getUserMobile() {
        return null;
    }

    @Override
    public void setUserMobile(String mobileNumber) {

    }

    @Override
    public boolean isCoachMarkView() {
        return false;
    }

    @Override
    public void setCoachMarkView(boolean coachMark) {

    }

    @Override
    public boolean isFirstTime() {
        return false;
    }

    @Override
    public void setFirstTime(boolean firstTime) {

    }

    @Override
    public void logoutUser() {

    }
}
