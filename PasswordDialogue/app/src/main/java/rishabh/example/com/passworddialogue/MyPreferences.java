package rishabh.example.com.passworddialogue;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jindal on 7/4/2016.
 */
public class MyPreferences {
    private static final String MY_PREFERENCES = "my_preferences";

    public static boolean isFirst(Context context){
        final SharedPreferences reader = context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        final boolean first = reader.getBoolean("is_first", true);
        if(first){
            final SharedPreferences.Editor editor = reader.edit();
            editor.putBoolean("is_first", false);
            editor.commit();
        }
        return first;
    }
}
