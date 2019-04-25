package spring.aop;

import java.lang.reflect.Method;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 17:55
 * @Description:
 */
public interface MethodMather {

    boolean methodMatch(Class target, Method method);
}
