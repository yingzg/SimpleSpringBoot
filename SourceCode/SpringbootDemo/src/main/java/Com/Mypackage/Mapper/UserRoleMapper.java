package Com.Mypackage.Mapper;

import Com.Mypackage.Model.UserRole;

import java.util.List;

public interface UserRoleMapper {

  public List<UserRole> GetUserRoleListByUserId(Integer userId);

  public int InsertUserRole(UserRole userRole);

}
