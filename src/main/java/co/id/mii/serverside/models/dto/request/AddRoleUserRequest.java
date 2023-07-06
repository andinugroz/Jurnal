package co.id.mii.serverside.models.dto.request;

import java.util.List;

public class AddRoleUserRequest {
    private Long userId;
    private List<String> roles;

    public AddRoleUserRequest(Long userId, List<String> roles) {
        this.userId = userId;
        this.roles = roles;
    }

    public AddRoleUserRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
