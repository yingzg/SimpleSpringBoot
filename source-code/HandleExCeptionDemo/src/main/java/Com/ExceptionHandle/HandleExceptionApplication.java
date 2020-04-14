package Com.ExceptionHandle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class HandleExceptionApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HandleExceptionApplication.class, args);
    }


}
