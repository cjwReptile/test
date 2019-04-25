package spring.aop;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.aspectj.weaver.tools.ShadowMatch;
import spring.annotation.AutoWired;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: cjw
 * @Date: 2019/1/4 15:46
 * @Description: 切点的实现
 */
public class AspectJExpressionPointCut implements ClassMather,MethodMather,Pointcut{


    private PointcutParser pointcutParser;

    @AutoWired
    private String expression;

    private PointcutExpression pointcutExpression;

    private static final Set<PointcutPrimitive> DEFAULT_SUPPORTED_PRIMITIVES = new HashSet<PointcutPrimitive>();

    static {
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.ARGS);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.REFERENCE);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.THIS);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.TARGET);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.WITHIN);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ANNOTATION);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_WITHIN);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ARGS);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_TARGET);
    }

    public AspectJExpressionPointCut() {
        this(DEFAULT_SUPPORTED_PRIMITIVES);
    }

    public AspectJExpressionPointCut(Set<PointcutPrimitive> supportedPrimitives) {
        pointcutParser = PointcutParser
                .getPointcutParserSupportingSpecifiedPrimitivesAndUsingContextClassloaderForResolution(supportedPrimitives);
    }

    void checkReadyToMatch(){
        if(pointcutExpression == null){
            pointcutExpression = pointcutParser.parsePointcutExpression(expression);
        }
    }


    @Override
    public boolean classMatch(Class target) {
        checkReadyToMatch();
        //判断当前类是否匹配，需要进行拦截
        return pointcutExpression.couldMatchJoinPointsInType(target);
    }

    /**
     *
     * 功能描述:
     * @param:
     * @return:
     * @auther: cjw
     * @date: 2019/1/4 16:44  判断当前方法是否符合拦截要求
     */
    @Override
    public boolean methodMatch(Class target, Method method) {
        checkReadyToMatch();
        ShadowMatch shadowMatch = pointcutExpression.matchesMethodExecution(method);
        if(shadowMatch.alwaysMatches()){
            return true;
        }else if(shadowMatch.neverMatches()){
            return false;
        }
        return false;
    }

    @Override
    public ClassMather getClassMather() {
        return this;
    }

    @Override
    public MethodMather getMethodMather() {
        return this;
    }

    public PointcutParser getPointcutParser() {
        return pointcutParser;
    }

    public void setPointcutParser(PointcutParser pointcutParser) {
        this.pointcutParser = pointcutParser;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public PointcutExpression getPointcutExpression() {
        return pointcutExpression;
    }

    public void setPointcutExpression(PointcutExpression pointcutExpression) {
        this.pointcutExpression = pointcutExpression;
    }
}
