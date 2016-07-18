package rishabh.example.com.swipetabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Jindal on 6/30/2016.
 */
public class FragmentPageAdaptor extends FragmentPagerAdapter {
    public FragmentPageAdaptor(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new JavaFragment();
            case 1:
                return new PHPFragment();
            case 2:
                return new NetFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
