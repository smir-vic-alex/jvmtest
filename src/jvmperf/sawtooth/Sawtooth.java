package jvmperf.sawtooth;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Class description
 *
 * @author sbrf-Smirnov-VA
 * @created on 2019-07-17
 */
public class Sawtooth {

    private static Unsafe unsafe;

    static {
        try{
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static long addressOf(Object o) throws Exception {
        Object[] array = new Object[]{o};

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch(addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }

        return objectAddress;
    }

    public static void main(String[] args) throws Exception{
        for (int i = 0; i< 32000; i++){
            Object mine = new GCMe();
            long address = addressOf(mine);
            System.out.println(address);
        }
    }
}

class GCMe{
    long data;
    long a;
    long aa;
    long aaa;
    long aaaa;
    long aaaaa;
    long aaaaaa;
    long aaaaaaa;
    long aaaaaaaa;
    long aaaaaaaaa;
    long aaaaaaaaaa;
    long aaaaaaaaaaa;
    long aaaaaaaaaaaa;
    long aaaaaaaaaaaaa;
    long aaaaaaaaaaaaaa;
    long aaaaaaaaaaaaaaa;
    long aaaaaaaaaaaaaaaa;
    long aaaaaaaaaaaaaaaaa;
    long aaaaaaaaaaaaaaaaaa;
}
