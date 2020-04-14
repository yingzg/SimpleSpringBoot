package Com.Example.Service;

import Com.Example.Mapper.UserMapper;
import Com.Example.Test.MybatisTest;
import Com.Example.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class UserService {

    private InputStream inputStream = MybatisTest.class.getResourceAsStream("/mybatisconfig.xml");
    private SqlSessionFactory Facrory = new SqlSessionFactoryBuilder().build(inputStream);



    public User selectUserById(Integer id) throws IOException {

        SqlSession sqlSession = Facrory.openSession();
        try
        {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getSingleUsers(3);
            sqlSession.commit();
            return  user;
        }
        finally
        {

            sqlSession.close();
        }
    }

    public User selectUserByName(String name) {
        SqlSession sqlSession = Facrory.openSession();
        try
        {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserByUsername("");
            sqlSession.commit();
            return  user;
        }
        finally
        {

            sqlSession.close();
        }
    }


}


