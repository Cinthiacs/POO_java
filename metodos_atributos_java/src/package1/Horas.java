package package1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Horas {
    public static void horas (String[] args)throws Exception{
        int min = 0;
        String nome;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Scanner input_user = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        System.out.println("Olá caro usuário! Qual o maior numero digitado");
        System.out.println("Digite seu nome: ");
        nome = input_user.nextLine();

        System.out.println(nome +" Digite um número: ");
        min = input_user.nextInt();

        while (min < 0){
            System.out.println(nome +" Digite um número inteiro positivo: ");
            min = input_user.nextInt();
        }

        float calcula_min = min / 60;
        if (min < 60){
            System.out.println(nome + " ");
        }
    }
}
