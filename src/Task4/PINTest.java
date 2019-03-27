package Task4;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;


class PINTest {





    @Test
    void checkPin() throws NoSuchFieldException {
        PIN testObject = new PIN(123);

        Class aClass = testObject.getClass();
        Field test = aClass.getField("access");
        test.setAccessible(true);

        test.getName();
    }
}