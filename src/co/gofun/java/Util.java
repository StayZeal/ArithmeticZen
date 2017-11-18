package co.gofun.java;

/**
 * Created by Ador on 2017/11/19.
 */
public class Util {

    public static void checkNull(Object o) {

        if (o == null) {
            throw new RuntimeException("object can noe be null");
        }
    }
}
