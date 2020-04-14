package Com.ExceptionHandle.Services.ServicesImpl;

public class BeanStaticFactorty {

    public static HelloServiceImpl HelloServiceInstance(String name,int age)
    {
        return new HelloServiceImpl(name,age);
    }

}
