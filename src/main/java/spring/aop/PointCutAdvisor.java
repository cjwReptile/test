package spring.aop;

/**
 * @Auther: cjw
 * @Date: 2019/1/3 17:58
 * @Description: 切面  拥有切点 与 通知
 */
public interface PointCutAdvisor extends Advisor{

    Pointcut getPointcut();
}
