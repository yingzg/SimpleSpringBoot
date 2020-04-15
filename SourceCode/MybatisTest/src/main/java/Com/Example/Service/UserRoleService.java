package Com.Example.Service;

import Com.Example.Mapper.UserRoleMapper;
import Com.Example.Test.MybatisTest;
import Com.Example.model.UserRole;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class UserRoleService {

    private InputStream inputStream = MybatisTest.class.getResourceAsStream("/mybatisconfig.xml");
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

}


