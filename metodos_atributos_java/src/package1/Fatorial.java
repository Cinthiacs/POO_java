package package1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Fatorial {
    public static void fatorial (String[] args)throws Exception{
        int min = 0;
        String nome;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Scanner input_user = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));
        
        System.out.println("Olá caro usuário! Vamos retornar o numero digitado em fatorial");
        System.out.println("Digite seu nome: ");
        nome = input_user.nextLine();

        System.out.println(nome +" Digite um número: ");
        int f = input_user.nextInt();       

        while (f < 0){
            System.out.println(nome +" Digite um número inteiro positivo: ");
            f = input_user.nextInt();
        }

        int fat = 1;
        for (int x = f; x > 0; x--){
           fat= fat * x; 
        
        }
        System.out.println("o fatorial de " + f + "!"+"=" + fat);
    }
}
