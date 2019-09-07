package NetworkUtils;

import android.content.Context;
import android.net.ConnectivityManager;

import androidx.annotation.Nullable;

public final class NetworkTools {
    private NetworkTools(){}

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        //ConnectivityManager.NetworkCallback activieNetwork = connectivityManager.getActiveNetwork();

        return true;
    }
}
