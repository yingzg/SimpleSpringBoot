package Com.ExceptionHandle.Services.ServicesImpl;

import Com.ExceptionHandle.Services.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("HelloService33")
public class HelloServiceImpl implements HelloService {


    @Value("卡卡")
    private String name;

    @Value("12")
    private  int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HelloServiceImpl() {
    }

    public HelloServiceImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void sayHello(String something) {

        System.out.println("hello, " + something);
    }

    @Override
    public String toString() {
        return "HelloServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}