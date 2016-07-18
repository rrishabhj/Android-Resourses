package rishabh.example.com.menubar;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Jindal on 7/13/2016.
 */
public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preference);
    }

}
