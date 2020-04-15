package com.example.express.Security.Exception;

import com.example.express.enums.ResponseErrorCodeEnum;
import org.springframework.security.core.AuthenticationException;

/**
 * 自定义授权异常
 */
public class DefaultAuthException extends AuthenticationException {
    public DefaultAuthException(String msg, Throwable t) {
        super(msg, t);
    }

    public DefaultAuthException(String msg) {
        super(msg);
    }

    public DefaultAuthException(ResponseErrorCodeEnum codeEnum) {
        super(codeEnum.getMsg());
    }
}
