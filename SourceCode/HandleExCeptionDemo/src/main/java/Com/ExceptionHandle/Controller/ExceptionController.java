package Com.ExceptionHandle.Controller;

import Com.ExceptionHandle.BeanYan;
import Com.ExceptionHandle.Exception.ResourceNotFoundException;
import Com.ExceptionHandle.Model.*;
import Com.ExceptionHandle.Services.HelloService;
import Com.ExceptionHandle.Services.ServicesImpl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ExceptionController {

     @Autowired
     private HelloServiceImpl service;


    @GetMapping("/resourceNotFound")
    public void throwException() {
        Person p=new Person();
        Map<String,Object> map=new HashMap<>();
        map.put(p.getName().toString(),p);

        throw new ResourceNotFoundException(map);
    }


    @PostMapping("/person")
    public ResponseEntity<Person> getPerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/PostPerson")
    public void ReturnData()
    {
        //需要代理的对象
        HelloService helloService = new HelloServiceImpl();
        //    方法反射处理回调
        InvocationHandler handler = new DynamicProxy<>(helloService);

        //通过 类加载器，接口类对象，反射回调，创建代理对象
        HelloService proxyInstance = (HelloService) Proxy.newProxyInstance(handler.getClass().getClassLoader(), helloService
                .getClass().getInterfaces(), handler);
        //System.out.println(subject.getClass().getName());
        proxyInstance.sayHello("ok");
    }

    @RequestMapping("/ReturnCglibData")
    public void ReturnCglibData()
    {
        //需要代理的对象
        HelloService helloService = new HelloServiceImpl();
        CglibProxy Proxy=new CglibProxy<>(helloService);
        HelloServiceImpl impl= (HelloServiceImpl)Proxy.GetProxyObject();
        impl.sayHello("这是Cglib代理");

    }



    @RequestMapping("/ReturnIocData")
    public void ReturnIocData()
    {




        String BeanConfig="applicationContext.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(BeanConfig);

        BeanYan book=(BeanYan)context.getBean("BeanYan");

        System.out.println("book is "+book.getBookName());
        ((ClassPathXmlApplicationContext)context).close();

       /* System.out.println("容器中已经定义的对象数量"+context.getBeanDefinitionCount());
        Iterator<String> iterator= Arrays.asList(context.getBeanDefinitionNames()).iterator();
        while (iterator.hasNext())
        {
            System.out.println("容器中已经定义的对象名"+iterator.next());
        }


        HelloServiceImpl service=(HelloServiceImpl) context.getBean("HelloService");
        service.sayHello("说点什么呢");

        Person person=(Person)context.getBean("Person");
        System.out.println(person.getCars().size()) ;
        System.out.println(person);*/
    }





}
