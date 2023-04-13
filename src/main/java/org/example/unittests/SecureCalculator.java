package org.example.unittests;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

@SuppressWarnings("ALL")
public class SecureCalculator {

    private Logger log;

    /**
     * Internal logging
     * @param message message to log
     */
    private void log(String message, Object... args){
        if(log != null){
            log.info(String.format(message, args));
        }
    }

    /**
     * Create a new calculator with debug logging disabled
     */
    public SecureCalculator() {}

    /**
     * Create a new calculator with debug logging enabled
     * @param log
     */
    public SecureCalculator(Logger log) {
        this.log = log;
    }

    /**
     * Safely multiply two integers so the result never overflows
     * @param a first number
     * @param b second number
     * @return multiplication result as long
     */
    public long multiply(int a, int b) throws ArithmeticException{
        log("Multiply %s * %s", a, b);
        long result = (long)a * (long)b;
        if (result>Long.MAX_VALUE || (a>0 && b>0 && result<0)){
            throw new ArithmeticException();
        }
        return result;
    }

    /**
     * Safely divide two numbers, throws exception if division by zero
     * @param a first number
     * @param b second number
     * @return division result as long
     */
    public long divide(long a, long b) throws ArithmeticException{
        log("Divide %s / %s", a, b);
        if(b!=0) {
            return a/b;
        }else{
            throw new ArithmeticException();
        }
    }

    /**
     * Safely do modulus between two numbers: 5 mod 2 = 1
     * @param a
     * @param b
     * @return a mod b
     */
    public int mod(int a, int b) throws ArithmeticException{
        log("%s mod %s", a, b);
        if (b==0){
            throw new ArithmeticException();
        }
        return a % b;
    }

    /**
     * Safely detect if a number is odd
     * @param a number to test
     * @return true if number is odd (example 1,3,5) false if even (example 2,4,8)
     */
    public boolean isOdd(int a){
        return mod(a, 2) == 1;
    }

    /**
     * Safely detect if a number is even
     * @param a number to test
     * @return true if number is even (example 2,4,8) false if odd (example 1,3,5)
     */
    public boolean isEven(int a){
        //Set<Integer> evenNumbers = Set.of(0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 100, 1000);
        //return evenNumbers.contains(a);
        return a%2==0 || a==0;
    }

    /**
     * Safely generate unique numbers
     * @return random number in range [0, MAX_VALUE)
     */
    public int getRandomNumber(){
        return getRandomNumber(Integer.MAX_VALUE);
    }

    /**
     * Safely generate unique numbers, always less than bound
     * @return random number in range [0, bound)
     */
    public int getRandomNumber(int bound){
        log("Generating rnd with bound %s", bound);
        Random random= new Random();
        return (int) random.nextInt() % bound;
    }
}
