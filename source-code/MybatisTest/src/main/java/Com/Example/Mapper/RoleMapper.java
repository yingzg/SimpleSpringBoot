package Com.Example.Mapper;

import Com.Example.model.Role;

public interface RoleMapper {

    public Role GetoneRoleByid(Integer Roleid);

    public Role GetRoleAndUsersByid(Integer id);

    public Role GetRoleAndUsersByid1(Integer id);
}
