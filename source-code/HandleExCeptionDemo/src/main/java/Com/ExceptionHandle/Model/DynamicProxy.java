package Com.ExceptionHandle.Model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理 被代理的类proxyObj，针对实现了接口的类进行代理
 * @param <T>
 */
public class DynamicProxy<T> implements InvocationHandler {

    //这里是泛型，通配型很强
     private T proxyObj;

    public DynamicProxy(T proxyObj) {
        this.proxyObj = proxyObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----------------------impl myself----------------------");
        //反射
        return method.invoke(proxyObj, args);
    }

}
