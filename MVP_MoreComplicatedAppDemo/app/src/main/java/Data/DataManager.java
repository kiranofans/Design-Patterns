package Data;

import AppModule.PreferencesHelper;
import Data.db.dao.UserDao;
import NetworkUtils.RestApiHelper;
import Utils.LoggedInMode;

public interface DataManager extends UserDao, PreferencesHelper, RestApiHelper {

    void updateApiHeader(Long userId, String accessToken);

    void setUserLoggedOut();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);
}
