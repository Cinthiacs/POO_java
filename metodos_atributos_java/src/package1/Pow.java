package package1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Pow {
    public static void pow (String[] args)throws Exception{
        int a = 0;
        int b = 0;
        String nome;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Scanner input_user = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));
        
        
        System.out.println("Olá caro usuário! Vamos calcular a^b");
        System.out.println("Digite seu nome: ");
        nome = input_user.nextLine();

        System.out.println(nome +" Digite um número: ");
        a = input_user.nextInt();
        
        System.out.println(nome + " Digite um numero novamente:");
        b = input_user.nextInt();

        double calcula_pow = Math.pow(a,b);
        System.out.println(nome + " O numero: " + a + " Elevado a " + b + " resulta em: \n" + calcula_pow);
    }
}