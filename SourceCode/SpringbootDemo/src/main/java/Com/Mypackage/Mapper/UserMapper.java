package Com.Mypackage.Mapper;

import Com.Mypackage.Model.User;

import java.util.List;

public interface UserMapper {

    public List<User> getoneUserById(List<Integer> ids);

    public User getSingleUsers(int id);

    public User getUserByUsername(String Username);


    public List<User> getUsersByRoleid(int Roleid);


    public int InsertUser(User entity);

    public int UpdateUser(User entity);

    public int DeleteUser(int id);



}
