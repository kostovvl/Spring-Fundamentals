package javaweb.workshop.domain.binding;

import org.hibernate.validator.constraints.Length;

public class LoginUserBinding {

    private String username;
    private String password;

    public LoginUserBinding() {
    }

    @Length(min = 2, message = "Username must be more than 2 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 3, message = "Password must be more than 3 characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
