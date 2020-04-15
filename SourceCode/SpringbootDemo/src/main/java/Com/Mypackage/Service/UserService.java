package Com.Mypackage.Service;

import Com.Mypackage.Mapper.UserMapper;

import Com.Mypackage.Model.User;
import Com.Mypackage.StarUp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class UserService {

    private InputStream inputStream = StarUp.class.getResourceAsStream("/mybatisconfig.xml");
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
            User user = mapper.getUserByUsername(name);
            sqlSession.commit();
            return  user;
        }
        finally
        {

            sqlSession.close();
        }
    }


    public int InsertUser(User user) {
        SqlSession sqlSession = Facrory.openSession();
        try
        {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res= mapper.InsertUser(user);
            sqlSession.commit();
            return res;
        }
        finally
        {

            sqlSession.close();
        }
    }

}


