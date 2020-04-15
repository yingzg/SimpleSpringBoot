package Com.Mypackage.Common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常捕获处理
 */

@RestControllerAdvice
public class GlobalExceptionhandle {

    @ExceptionHandler(value=Exception.class)
    Object handleException(Exception e, HttpServletRequest request)
    {
        Map<String ,Object> map=new HashMap<>();
        map.put("code",100);
        map.put("msg",e.getMessage());
        map.put("code",request.getRequestURI());
        return  map;

    }

}




