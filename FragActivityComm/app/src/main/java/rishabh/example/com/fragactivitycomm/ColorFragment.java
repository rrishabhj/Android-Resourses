package rishabh.example.com.fragactivitycomm;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by Jindal on 6/29/2016.
 */
public class ColorFragment extends Fragment {
    RadioGroup viewGroup;

    ColorChanger colorChanger;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v=inflater.inflate(R.layout.color_fragment_layout,container,false);
        viewGroup=(RadioGroup)v.findViewById(R.id.color_group);
        viewGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.blue:colorChanger.colorchange("blue");
                        break;
                    case R.id.green:colorChanger.colorchange("green");
                        break;
                    case R.id.red:colorChanger.colorchange("red");
                        break;
                }

            }
        });
                return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        colorChanger=(ColorChanger)activity;
    }

    public interface ColorChanger{
        public void colorchange(String color);
    }
}
