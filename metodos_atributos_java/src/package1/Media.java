package package1;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Media {
    public static void media (String[] args)throws Exception{
        float num_1 = 0;
        float num_2 = 0;
        float num_3 = 0;
        String nome;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Scanner input_user = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        System.out.println("Olá caro usuário! Vamos calcular a media aritimetica");
        System.out.println("Digite seu nome: ");
        nome = input_user.nextLine();

        System.out.println(nome +" Digite um número: ");
        num_1 = input_user.nextInt();
        while (num_1 < 0){
            System.out.println(nome + " Digite um número inteiro > que 0: ");
            num_1 = input_user.nextInt();
        }

        System.out.println(nome +" Digite um número: ");
        num_2 = input_user.nextInt();
        while (num_2 < 0){
            System.out.println(nome + " Digite um número inteiro > que 0: ");
            num_2 = input_user.nextInt();
        }

        System.out.println(nome +" Digite um número: ");
        num_3 = input_user.nextInt();
        while (num_3 < 0){
            System.out.println(nome + " Digite um número inteiro > que 0: ");
                num_3 = input_user.nextInt();
        }      

        double media_aritimetica = (num_1 + num_2 + num_3)/3;
               
        if (num_1 >= 0 && num_2 >= 0 && num_3 >= 0){
            System.out.println(nome + " A média aritimética de " + num_1 + " + "+ num_2 + " + " + num_3);
            System.out.println(" Resulta em: " + media_aritimetica);
        }else{
            System.out.print ("Pressione qualquer tecla para terminar o programa ");
            System.in.read();
        }

    }
}
