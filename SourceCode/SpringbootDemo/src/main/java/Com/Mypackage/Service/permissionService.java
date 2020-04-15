package Com.Mypackage.Service;

import Com.Mypackage.Mapper.RoleMapper;
import Com.Mypackage.Mapper.SysPermissionMapper;
import Com.Mypackage.Model.Role;
import Com.Mypackage.Model.SysPermission;
import Com.Mypackage.StarUp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class permissionService {

    private InputStream inputStream = StarUp.class.getResourceAsStream("/mybatisconfig.xml");
    private SqlSessionFactory Facrory = new SqlSessionFactoryBuilder().build(inputStream);

    public List<SysPermission> GetPermissionByRoleId(Integer RoleId) throws IOException {

        SqlSession sqlSession = Facrory.openSession();
        try
        {
            SysPermissionMapper mapper = sqlSession.getMapper(SysPermissionMapper.class);
            List<SysPermission> Permissions = mapper.GetPermissionByRoleId(3);
            sqlSession.commit();
            return  Permissions;
        }
        finally
        {

            sqlSession.close();
        }
    }

}
