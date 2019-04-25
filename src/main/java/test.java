
import design.observer.Observer;
import design.observer.Observer2;
import design.observer.Subject;
import design.observer.SubjectInterface;
import org.apache.commons.collections.map.HashedMap;
import spring.Context.ClassXmlApplicationContext;
import spring.Out;
import spring.OutService;
import spring.aop.*;
import spring.factory.AbstractBeanFactory;
import spring.factory.AutoApplyPropertyBeanFactory;
import sun.security.util.BitArray;

import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class test {

    public static void main(String[] args) throws Exception {


        BitSet bitSet  = new BitSet();
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(5);
        BitSet bitSet1 = new BitSet();
        bitSet1.set(5);
        bitSet.and(bitSet1);
        int i = bitSet.cardinality();
        System.out.println("ss");
    }
}

