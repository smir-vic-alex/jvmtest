package jvmperf.reflection;

/**
 * Class description
 *
 * @author sbrf-Smirnov-VA
 * @created on 2019-07-18
 */
public class Demo {

    public static void main(String[] args) throws Exception {

        Class clazz = Class.forName("jvmperf.reflection.Alpha");

        int mask = clazz.getModifiers();

        System.out.println(mask);
    }
}

abstract class Alpha {

}
