package arcadia.utils;

import java.util.Random;

public class StringHelper {
    public Integer generateRandomDigit(){
       return new Random().nextInt(10000);
    }
}
