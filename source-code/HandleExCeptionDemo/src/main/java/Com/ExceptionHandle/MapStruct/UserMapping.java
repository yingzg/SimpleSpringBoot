package Com.ExceptionHandle.MapStruct;

import Com.ExceptionHandle.Model.User;
import Com.ExceptionHandle.Model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.alibaba.fastjson.JSON;
import org.mapstruct.factory.Mappers;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",imports = {LocalDateTime.class})
public interface UserMapping extends BaseMapping<User, UserDto> {

    UserMapping USER_MAPPING = Mappers.getMapper(UserMapping.class);


    @Mapping(target = "gender", source = "sex")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Override
    UserDto sourceToTarget(User var1);

    @Mapping(target = "sex", source = "gender")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss",expression = "java(LocalDateTime.now())")
    @Override
    User targetToSource(UserDto var1);

    default List<UserDto.UserConfig> strConfigToListUserConfig(String ss) {
        return (List<UserDto.UserConfig>) JSON.parseArray(ss , UserDto.UserConfig.class);
    }

    default String listUserConfigToStrConfig(List<UserDto.UserConfig> list) {
        return JSON.toJSONString(list);
    }
}
