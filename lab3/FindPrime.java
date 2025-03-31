public class FindPrime {
    public static void main(String args[]) {
        int number = 30;
        int[] primes = new int[0];
        boolean isPrime = true;
        for (int i = 2; i < (number / 2)+1; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        for (int i = 2; i < number; i++) {
            boolean isPrime2 = true;
            for (int j = 2; j < (i / 2)+1; j++) {
                if (i % j == 0) {
                    isPrime2 = false;
                    break;
                }
            }
            if(isPrime2){
                primes = ArrayUtils.add(primes,i);
                System.out.println(i);
            }
        }
        System.out.println(number + " is " + (isPrime ? "a prime number." : "not a prime number."));
    }
}
