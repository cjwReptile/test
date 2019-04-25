package spring;

import spring.annotation.AutoWired;

/**
 * @Auther: cjw
 * @Date: 2019/1/2 17:35
 * @Description:
 */
public class Out implements OutService{

    @AutoWired
    public String test;

    public String test_2;

    @Override
    public void print(){
        System.out.println(test);
    }

}
