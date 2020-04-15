package Com.ExceptionHandle.Model;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy<T> implements MethodInterceptor {

    //这里是泛型，通配型很强
    private T proxyObj;

    public CglibProxy(T proxyObj) {
        this.proxyObj = proxyObj;
    }

    public <T extends Object> T GetProxyObject()
    {
        // 生成代理对象
        Enhancer enhancer = new Enhancer();
        // 设置对谁进行代理
        enhancer.setSuperclass(proxyObj.getClass());
        // 代理要做什么
        enhancer.setCallback(this);
        // 创建代理对象
        T us = (T) enhancer.create();

        return us;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        Object invoke = methodProxy.invokeSuper(o, args);
        System.out.println("提交事务");
        return invoke;
    }
}
