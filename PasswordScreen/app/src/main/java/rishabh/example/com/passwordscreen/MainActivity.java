package rishabh.example.com.passwordscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.wordpress.passcodelock.AppLockManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppLockManager.getInstance().enableDefaultAppLockIfAvailable(this);

    }


}
