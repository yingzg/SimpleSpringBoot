package Com.Example.model;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

    private int id;

    private String RoleName;

    private List<User> UserList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public List<User> getUserList() {
        return UserList;
    }

    public void setUserList(List<User> userList) {
        UserList = userList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", RoleName='" + RoleName + '\'' +
                ", UserList=" + UserList +
                '}';
    }
}
