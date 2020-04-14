package Com.Mypackage.Service;

import Com.Mypackage.Mapper.RoleMapper;
import Com.Mypackage.Model.Role;
import Com.Mypackage.StarUp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class RoleService {

    private InputStream inputStream = StarUp.class.getResourceAsStream("/mybatisconfig.xml");
    private SqlSessionFactory Facrory = new SqlSessionFactoryBuilder().build(inputStream);

    public Role selectRoleById(Integer id) throws IOException {

        SqlSession sqlSession = Facrory.openSession();
        try
        {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role role = mapper.GetoneRoleByid(3);
            sqlSession.commit();
            return  role;
        }
        finally
        {

            sqlSession.close();
        }
    }

    public Role selectRoleByRoleName(String Rolename) throws IOException {

        SqlSession sqlSession = Facrory.openSession();
        try
        {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role role = mapper.selectRoleByRoleName(Rolename);
            sqlSession.commit();
            return  role;
        }
        finally
        {

            sqlSession.close();
        }
    }


}
