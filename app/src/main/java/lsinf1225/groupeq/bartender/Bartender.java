package lsinf1225.groupeq.bartender;

import android.app.Application;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by alexis on 30/04/15.
 */
public class Bartender extends Application {

    private static Bartender context;

    public static int table = 1;
    public static String connectedUser = null;

    public static Bartender getContext(){
        return context;
    }

    public void onCreate() {
        super.onCreate();
        context = (Bartender) getApplicationContext();
    }
}
