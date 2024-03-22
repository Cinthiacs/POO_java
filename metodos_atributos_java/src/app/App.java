package app;
import package1.Compare;
import package1.Horas;
import package1.Media;
import package1.Numbers;
import package1.Pow;
import package1.Fatorial;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Scanner input_user = new Scanner(System.in);
        int escolha_usu = 0;
        

        

        do{
            System.out.println("\n Escolha a opcao abaixo: \n" +
            "1 para Verificar Número Positivo\n" +
            "2 para Verificar Média Aritmética\n" +
            "3 para Verificar o maior número\n"+
            "4 para Verificar a potencia a^b\n"+
            "5 para verificar as horas \n"+
            "6 para verificar o fatorial \n"+
            "0 para Encerrar o programa: \n");

            escolha_usu = input_user.nextInt();

            switch (escolha_usu) {
                case 1:
                    Numbers.num (args);
                    break;
                case 2:
                    Media.media (args);
                    break;
                case 3:
                    Numbers.num(args);
                    break;
                case 4:
                    Pow.pow(args);
                    break;

                case 5:
                    Horas.horas(args);
                    break;

                case 6:
                    Fatorial.fatorial(args);
                    break;

                case 0:
                    System.out.print ("Pressione qualquer tecla para encerrar o programa ");
                    System.in.read();
                    break;

                default:
                    System.out.println("Opção invalida, digite novamente entre 1 e 4: \n");
            } 
        }while(escolha_usu != 0);
    }
}