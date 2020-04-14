package Com.Example.Service;

import Com.Example.Mapper.RoleMapper;
import Com.Example.Test.MybatisTest;
import Com.Example.model.Role;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class RoleService {

    private InputStream inputStream = MybatisTest.class.getResourceAsStream("/mybatisconfig.xml");
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

}
