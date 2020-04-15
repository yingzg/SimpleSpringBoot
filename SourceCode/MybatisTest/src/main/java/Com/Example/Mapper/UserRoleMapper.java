package Com.Example.Mapper;

import Com.Example.model.UserRole;

import java.util.List;

public interface UserRoleMapper {

  public List<UserRole> GetUserRoleListByUserId(Integer userId);
}
