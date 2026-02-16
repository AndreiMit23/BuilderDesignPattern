package BDP;

public class ExceptionHandler {

    public void handle(Exception e) {

    	//verificare cred ca stii ce fac aici :)) verific daca exceptia primita e de tip ArithmeticException sau celelalte
    	//o sa am nevoie mai departe in EnemyPanel ca sa pot trata jocul
        if (e instanceof ArithmeticException) {
            System.out.println("Prins ArithmeticException");

        } else if (e instanceof NullPointerException) {
            System.out.println("Prins NullPointerException");

        } else if (e instanceof ArrayIndexOutOfBoundsException) {
            System.out.println("Prins ArrayIndexOutOfBoundsException");

        } else {
            System.out.println("Alta exceptie: " + e);
        }
    }
}

