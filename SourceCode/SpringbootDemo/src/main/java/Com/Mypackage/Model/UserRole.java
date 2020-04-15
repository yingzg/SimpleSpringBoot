package Com.Mypackage.Model;

import java.io.Serializable;

public class UserRole implements Serializable {

    private Integer Id;

    private Integer userId;

    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    public UserRole(Integer userid,Integer roleid)
    {
        this.userId=userid;
        this.roleId=roleid;

    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
