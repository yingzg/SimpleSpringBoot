package Com.Mypackage.Mapper;

import Com.Mypackage.Model.SysPermission;

import java.util.List;

public interface SysPermissionMapper {

   public List<SysPermission> GetPermissionByRoleId(Integer roleId);

}
