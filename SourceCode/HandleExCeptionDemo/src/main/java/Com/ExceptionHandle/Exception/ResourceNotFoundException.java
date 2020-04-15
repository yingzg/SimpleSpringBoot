package Com.ExceptionHandle.Exception;

import java.util.Map;

/**
 * 自定义异常类型
 */
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(Map<String, Object> data) {
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }
}
