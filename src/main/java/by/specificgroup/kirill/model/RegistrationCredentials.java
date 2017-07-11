package by.specificgroup.kirill.model;

/**
 * Created by user1 on 7/10/2017.
 */
public class RegistrationCredentials {
    private String email;
    private String password;
    private String username;

    public RegistrationCredentials(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public RegistrationCredentials() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
