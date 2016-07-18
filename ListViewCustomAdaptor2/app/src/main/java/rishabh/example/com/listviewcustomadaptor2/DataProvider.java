package rishabh.example.com.listviewcustomadaptor2;

/**
 * Created by Jindal on 6/28/2016.
 */
public class DataProvider {
    private String large,small;

    public DataProvider(String large, String small) {
        this.large = large;
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}
