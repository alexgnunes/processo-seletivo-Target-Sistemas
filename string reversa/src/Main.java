import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("digite uma palavra: ");
        String palavra = sc.nextLine();

        for(int i = (palavra.length() - 1); i >=0; i--){
            char c = palavra.charAt(i);
            System.out.print(c);
        }
        sc.close();
    }
}