package javaweb.workshop.domain.servicemodel;

import javaweb.workshop.domain.entity.Role;

public class SetUserServiceModel extends BaseServiceModel {

    private String username;
    private String password;
    private String email;
    private String git;
    private SetRoleServiceModel role;

    public SetUserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public SetRoleServiceModel getRole() {
        return role;
    }

    public void setRole(SetRoleServiceModel role) {
        this.role = role;
    }
}