package rishabh.example.com.swipetabs;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{

    FragmentPageAdaptor fragmentPageAdaptor;
    ViewPager viewPager;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar=getSupportActionBar();
        viewPager=(ViewPager)findViewById(R.id.viewPager);

        fragmentPageAdaptor=new FragmentPageAdaptor(getSupportFragmentManager());

        viewPager.setAdapter(fragmentPageAdaptor);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("java").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("C++").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(".NEt").setTabListener(this));

        //so that when tab is clicked it swipe to that page

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
