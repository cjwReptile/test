package spring.aop;


import org.aopalliance.aop.Advice;
import spring.annotation.AutoWired;

/**
 * @Auther: cjw
 * @Date: 2019/1/4 16:47
 * @Description:
 */
public class AspectJExpressionPointCutAdvisor implements PointCutAdvisor {


    private AspectJExpressionPointCut aspectJExpressionPointCut = new AspectJExpressionPointCut();

    @AutoWired
    private Advice advice;

    private String expression;

    public AspectJExpressionPointCutAdvisor(){
    }

    @Override
    public Pointcut getPointcut() {
        return aspectJExpressionPointCut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
        this.aspectJExpressionPointCut.setExpression(this.expression);
    }
}
