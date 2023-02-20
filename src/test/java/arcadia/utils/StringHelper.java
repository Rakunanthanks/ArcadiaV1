package arcadia.utils;

import java.util.Random;
import java.util.UUID;

public class StringHelper {
    public Integer generateRandomDigit(){
       return new Random().nextInt(10000);
    }

    //Generate UUID in uppercase
    public String generateRandomUUID(){
         String uuid = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        return uuid;
    }

}
