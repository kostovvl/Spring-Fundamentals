package softuni.workshop.domain.service;

import softuni.workshop.domain.entity.Role;

public class SetUserService extends BaseService {

    private String username;
    private String password;
    private String email;
    private String git;
    private SetRoleService role;

    public SetUserService() {
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

    public SetRoleService getRole() {
        return role;
    }

    public void setRole(SetRoleService role) {
        this.role = role;
    }
}
