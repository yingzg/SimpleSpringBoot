package Com.Mypackage.Service;

import Com.Mypackage.Mapper.UserMapper;
import Com.Mypackage.Mapper.UserRoleMapper;
import Com.Mypackage.Model.User;
import Com.Mypackage.Model.UserRole;
import Com.Mypackage.StarUp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class UserRoleService {

    private InputStream inputStream = StarUp.class.getResourceAsStream("/mybatisconfig.xml");
    private SqlSessionFactory Facrory = new SqlSessionFactoryBuilder().build(inputStream);

    public  List<UserRole> selectRoleById(Integer id) throws IOException {

        SqlSession sqlSession = Facrory.openSession();
        try
        {
            UserRoleMapper mapper = sqlSession.getMapper(UserRoleMapper.class);
            List<UserRole> UserRoleList = mapper.GetUserRoleListByUserId(3);
            sqlSession.commit();
            return  UserRoleList;
        }
        finally
        {

            sqlSession.close();
        }
    }


    public int InsertUserRole(UserRole userRole) {
        SqlSession sqlSession = Facrory.openSession();
        try
        {
            UserRoleMapper mapper = sqlSession.getMapper(UserRoleMapper.class);
            int res= mapper.InsertUserRole(userRole);
            sqlSession.commit();
            return res;
        }
        finally
        {

            sqlSession.close();
        }
    }


}


