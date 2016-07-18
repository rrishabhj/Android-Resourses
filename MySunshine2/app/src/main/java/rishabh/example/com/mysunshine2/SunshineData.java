package rishabh.example.com.mysunshine2;

import android.graphics.Bitmap;

/**
 * Created by Jindal on 7/17/2016.
 */
public class SunshineData {
    private String low_temp,high_temp,day,forcast;
    private Bitmap forcast_icon_resource;

    public SunshineData(String low_temp, String high_temp, String day, String forcast, Bitmap forcast_icon_resource) {
        this.low_temp = low_temp;
        this.high_temp = high_temp;
        this.day = day;
        this.forcast = forcast;
        this.forcast_icon_resource = forcast_icon_resource;
    }

    public String getLow_temp() {
        return low_temp;
    }

    public void setLow_temp(String low_temp) {
        this.low_temp = low_temp;
    }

    public String getHigh_temp() {
        return high_temp;
    }

    public void setHigh_temp(String high_temp) {
        this.high_temp = high_temp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getForcast() {
        return forcast;
    }

    public void setForcast(String forcast) {
        this.forcast = forcast;
    }

    public Bitmap getForcast_icon_resource() {
        return forcast_icon_resource;
    }

    public void setForcast_icon_resource(Bitmap forcast_icon_resource) {
        this.forcast_icon_resource = forcast_icon_resource;
    }
}
