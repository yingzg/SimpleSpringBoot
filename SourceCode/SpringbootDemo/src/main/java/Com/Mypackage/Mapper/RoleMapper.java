package Com.Mypackage.Mapper;

import Com.Mypackage.Model.Role;

public interface RoleMapper {

    public Role GetoneRoleByid(Integer Roleid);

    public Role GetRoleAndUsersByid(Integer id);

    public Role selectRoleByRoleName(String Rolename);
}
