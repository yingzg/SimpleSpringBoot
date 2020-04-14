package Com.Example.Mapper;

import Com.Example.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * Mybatis 处理 范围传参
     * @param ids
     * @return
     */
    public List<User> getRangUser(@Param("MaxId") int MaxId, @Param("MinId")int MinId);

    /**
     * 一对一关系  字标签级联查询
     * @param id
     * @return
     */
    public User getSingleUsers(int id);

    /**
     * 一对一关系 分步查询
     * @param id
     * @return
     */
    public User getSingleUsers1(int id);



    public User getUserByUsername(String Username);

    /**
     * 模糊查询
     * @param Usernamelike
     * @return
     */
    public User getUserByUsernameLike(String Usernamelike);


    /**
     * 集合查询
     * @param Ids
     * @return
     */
    public List<User> getUserList(List<Integer> Ids);



    /**
     * 关联分步查询
     * @param Roleid
     * @return
     */
    public List<User> getUsersByRoleid(int Roleid);





    public int InsertUser(User entity);

    public int UpdateUser(User entity);

    public int DeleteUser(int id);



}
