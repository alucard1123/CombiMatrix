package com.Generator;

import java.util.Random;

/**
 * User: edward
 * Date: 11/27/13
 * Time: 11:10 AM
 */
public class GenSub {
    public static char GenChar(){
        Random random = new Random();
        int UperOrNot = random.nextInt(2) % 2 == 0 ? 65 : 97; // uper litter or not
        return (char)(UperOrNot + random.nextInt(26));
    }
}
