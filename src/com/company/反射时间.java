package com.company;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
class TestMethod {
    public void test() {
        for(int i = 0 ; i < 10; i ++) {
            System.out.print("");
        }
    }
}
public class 反射时间 {
    private long start;
    private int methodCount = 10000000;
    private static Map<String, Method> map = new HashMap<>();
//@Before：表示使用此注解的方法在每个@Test调用之前被执行，即一个类中有多少个@Test注解方法，那么@Before注解的方法就会被调用多少次
    @Before
    public void before(){
        start = System.currentTimeMillis();
    }
//@After：表示使用此注解的方法在每个@Test调用结束之后被执行，即一个类中有多少个@Test注解方法，那么@Before注解的方法就会被调用多少次
    @After
    public void after() {
        System.out.println(System.currentTimeMillis() - start);
    }
    /**
     * 普通方法
     */
    @Test
    public void test1() {
        TestMethod method = new TestMethod();
        for(int i = 0 ; i < methodCount ; i ++) {
            method.test();
        }
    }
    /**
     * 反射执行方法
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        TestMethod testmethod = new TestMethod();
        for(int i = 0 ; i < methodCount ; i ++) {
            testmethod.getClass().getMethod("test").invoke(testmethod);
        }
    }
    /**
     * 模拟将反射得到的 Method 方法放到缓存中
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        TestMethod testMethod = new TestMethod();
        for(int i = 0 ; i < methodCount ; i ++) {
            Method method = map.get("test");
            if(method != null) {
                method.invoke(testMethod);
            } else {
                method = testMethod.getClass().getMethod("test");
                map.put("test", method);
                method.invoke(testMethod);
            }
        }
    }

}
