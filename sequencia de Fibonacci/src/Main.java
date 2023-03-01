import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int numero = sc.nextInt();

        int a = 0;
        int somaSequencia = 0;
        int b = 1;

        while (numero > somaSequencia) {
            somaSequencia = a + b;
            a = b;
            b = somaSequencia;
        }
        if (numero == somaSequencia) {
            System.out.println("O numero pertence a sequencia de Fibonacci");
        } else {
            System.out.println("O numero nao pertence a sequencia de Fibonacci");
        }
        sc.close();
    }
}
