package util;

public class RandomNumber {

    public static int generateRandomNumber(int minimum, int maximum) {
       return  (int) (Math.random() * maximum) + minimum;
    }
}
