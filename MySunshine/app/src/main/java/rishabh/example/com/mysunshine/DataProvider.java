package rishabh.example.com.mysunshine;

/**
 * Created by Jindal on 7/13/2016.
 */
public class DataProvider {
    private String day,type,maxTemp,minTemp;

    public DataProvider(String day, String type, String maxTemp, String minTemp) {
        this.day = day;
        this.type = type;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }
}
