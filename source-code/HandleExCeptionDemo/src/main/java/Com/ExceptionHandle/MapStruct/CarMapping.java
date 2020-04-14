package Com.ExceptionHandle.MapStruct;

import Com.ExceptionHandle.Model.Car;
import Com.ExceptionHandle.Model.CarDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapping {

    /**
     * 用来调用实例 实际开发中可使用注入Spring  不写
     */
    CarMapping CAR_MAPPING = Mappers.getMapper(CarMapping.class);


    /**
     * 源类型 目标类型 成员变量相同类型 相同变量名 不用写{@link org.mapstruct.Mapping}来映射
     *
     * @param car the car
     * @return the car dto
     */
    @Mapping(target = "type", source = "cartype.type")
    @Mapping(target = "seatCount", source = "numberOfSeats")
    CarDTO carToCarDTO(Car car);


}
