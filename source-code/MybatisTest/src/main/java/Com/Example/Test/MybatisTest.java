package Com.Example.Test;


import Com.Example.Mapper.RoleMapper;
import Com.Example.Mapper.UserMapper;
import Com.Example.model.Role;
import Com.Example.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {



    @Test
    public void Test() throws IOException {

        InputStream inputStream= MybatisTest.class.getResourceAsStream("/mybatisconfig.xml");
        SqlSessionFactory Facrory=new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession=Facrory.openSession();

        try{
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

            Role list = mapper.GetRoleAndUsersByid1(3);
            System.out.println(list);
            sqlSession.commit();
        }
        finally {

            sqlSession.close();
        }
    }

    @Test
    public void Test1() throws IOException{

        InputStream inputStream= MybatisTest.class.getResourceAsStream("/mybatisconfig.xml");
        SqlSessionFactory Facrory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=Facrory.openSession();

        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<Integer> list= new ArrayList<Integer>();
            list.add(1);
            list.add(3);
            list.add(4);
            List<User> userList =mapper.getUserList(list);
            System.out.println(userList);
            sqlSession.commit();

            User user =mapper.getSingleUsers1(1);
            System.out.println(user);
            sqlSession.commit();


            User user1 =mapper.getUserByUsernameLike("suo");
            System.out.println(user1);
            sqlSession.commit();

        }
        finally {
            sqlSession.close();
        }

    }


}
