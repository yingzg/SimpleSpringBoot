package Com.ExceptionHandle.Services.ServicesImpl;

public class DemicBeanFactory {

    public HelloServiceImpl HelloServiceInstance(String name,int age)
    {
        return new HelloServiceImpl(name,age);
    }
}
