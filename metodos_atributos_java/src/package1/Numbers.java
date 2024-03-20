package package1;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Numbers {
    public static void num (String[] args)throws Exception{
        
        int num1 = 0;
        String nome;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Scanner input_user = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        System.out.println("Olá caro usuário!");
        System.out.println("Digite seu nome: ");
        nome = input_user.nextLine();

        System.out.println(nome +" Digite um número inteiro: ");
        num1 = input_user.nextInt();

        while(num1 < 0){
            System.out.println(nome + " Digite um número inteiro > que 0: ");
            num1 = input_user.nextInt();
        }

        if(num1 >= 0){
            System.out.println(nome + " Voce digitou um numero positivo: " + num1);
        }else{
            System.out.print ("Pressione qualquer tecla para terminar o programa ");
            System.in.read();
        }
    }
}

