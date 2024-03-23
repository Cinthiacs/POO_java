package package1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Compare {
    public static void compare (String[] args)throws Exception{
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        String nome;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Scanner input_user = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        System.out.println("Olá caro usuário! Qual o maior numero digitado");
        System.out.println("Digite seu nome: ");
        nome = input_user.nextLine();

        System.out.println(nome +" Digite um número: ");
        n1 = input_user.nextInt();
        
        System.out.println(nome + " Digite um numero novamente:");
        n2 = input_user.nextInt();

        System.out.println(nome + " Digite um numero novamente:");
        n3 = input_user.nextInt();

        int maior = n1;

        if (n2 > maior){
            maior = n2;
        }

        if (n3 > maior){
            maior = n3;
        }
        System.out.println("O maior numero que voce digitou foi: " + maior);
    }
}
