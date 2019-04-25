package spring.aop;

import org.aopalliance.aop.Advice;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 17:48
 * @Description: 通知，获取通知
 */
public interface Advisor {

    Advice getAdvice();
}
