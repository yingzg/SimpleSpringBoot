package Com.Example;

import Com.Example.Test.MybatisTest;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;

@SpringBootApplication
@ServletComponentScan
public class MabatisApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MabatisApplication.class, args);
    }

}