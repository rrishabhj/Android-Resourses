package rishabh.example.com.jsonarraydemo;

/**
 * Created by Jindal on 7/13/2016.
 */
public class Contact {
    private String name,email;

    Contact(){

    }
    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
