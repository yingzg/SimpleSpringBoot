package Com.ExceptionHandle.Test;

import Com.ExceptionHandle.MapStruct.CarMapping;
import Com.ExceptionHandle.MapStruct.UserMapping;
import Com.ExceptionHandle.Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Administrator
 */
@AutoConfigureMockMvc
@SpringBootTest
public class ExceptionTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

   /* @Resource
    private UserMapping userMapping;*/

/*    @Autowired
    UserMappingImpl UserMappingImpl;*/

    @Test
   public void should_return_400_if_param_not_valid() throws Exception {
        mockMvc.perform(get("/api/illegalArgumentException"))
                .andExpect(status().is(400))
                .andExpect(jsonPath("$.message").value("参数错误!"));
    }


    @Test
    public void should_return_404_if_resourse_not_found() throws Exception {
        mockMvc.perform(get("/api/resourceNotFoundException"))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$.message").value("Sorry, the resourse not found!"));
    }



    @Test
    public void testCarDto()
    {

       CarMapping carmapping = CarMapping.CAR_MAPPING;

        Car car = new Car();
        car.setCartype(new CarType("这是carType"));
        car.setMake("haha");
        car.setNumberOfSeats(10);

        CarDTO carDTO=new CarDTO();
        carDTO= carmapping.carToCarDTO(car);
        System.out.println("carDTO: "+carDTO);

    }


    @Test
    public void tetDomain2DTO() {

        UserMapping userMapping = UserMapping.USER_MAPPING;

        User user = new User()
                .setId(1L)
                .setUsername("zhangsan")
                .setSex(1)
                .setPassword("abc123")
                .setCreateTime(LocalDateTime.now())
                .setBirthday(LocalDate.of(1999, 9, 27))
                .setConfig("[{\"field1\":\"Test Field1\",\"field2\":500}]");
        UserDto UserDto =  userMapping.sourceToTarget(user);

        System.out.println("User: "+user);
        System.out.println("UserDto: "+UserDto);

    }

    @Test
    public void testDTO2Domain() {
        UserMapping userMapping = UserMapping.USER_MAPPING;

        UserDto.UserConfig userConfig = new UserDto.UserConfig();
        userConfig.setField1("Test Field1");
        userConfig.setField2(500);

        UserDto UserDto = new UserDto()
                .setId(1L)
                .setUsername("zhangsan")
                .setGender(2)

                .setBirthday(LocalDate.of(1999, 9, 27))
                .setConfig(Collections.singletonList(userConfig));
        User user = userMapping.targetToSource(UserDto);

        System.out.println("User: "+user);
        System.out.println("UserDto: "+UserDto);


    }

    @Test
    public void should_get_person_correctly() throws Exception {
        Person person = new Person();
        person.setName("SnailClimb");
        person.setSex("Man");
        person.setClassId("82938390");
        person.setEmail("Snailclimb@qq.com");

        mockMvc.perform(post("/api/person")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(person)))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("SnailClimb"))
                .andExpect(MockMvcResultMatchers.jsonPath("classId").value("82938390"))
                .andExpect(MockMvcResultMatchers.jsonPath("sex").value("Man"))
                .andExpect(MockMvcResultMatchers.jsonPath("email").value("Snailclimb@qq.com"));
    }

    @Test
    public void should_check_person_value() throws Exception {
        Person person = new Person();
        person.setSex("Man22");
        person.setClassId("82938390");
        person.setEmail("SnailClimb");

        mockMvc.perform(post("/api/person")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(person)))
                .andExpect(MockMvcResultMatchers.jsonPath("sex").value("这是不正确的sex值"))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("这是不正确的name"))
                .andExpect(MockMvcResultMatchers.jsonPath("email").value("这是不正确的email格式"));
    }




}
