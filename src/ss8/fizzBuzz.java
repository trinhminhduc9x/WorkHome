package ss8;

public class fizzBuzz {

    public static String fizzBuzz(int number){
        boolean isFizz = number % 3==0;
        boolean isBuzz = number % 5==0;
        if(isBuzz &&isFizz)
            return "FizzBuzz";

        if(isFizz)
            return "Fizz";

        if(isBuzz)
            return "Buzz";

        return number + "";
    }
}
