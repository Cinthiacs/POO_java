package package1;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Protected só é visivel nos pacotes dentro da classe
public class Filmes {
        protected String titulo;
        protected int duracao;
        protected String genero;

        public String get_titulo(){
            return titulo;
        }
        public void set_titulo(String titulo) throws Exception{
            if(titulo.isEmpty()|| titulo == null){
                throw new Exception("Nome do filme é obrigatorio");
            }
            this.titulo = titulo; 
        }

        public Integer get_duracao(){
            return duracao;
        }
        public void set_duracao(Integer duracao) throws Exception{
            if(duracao < 0 || duracao == null){
                throw new Exception("A duração deve ser maior que 0");
            }
            this.duracao = duracao;
        }

        public String get_genero(){
            return genero;
        }
        public void set_genero(String genero)throws Exception{
                if(!genero.equals("Comedia") && !genero.equals("Romance") && !genero.equals("Terror")){
                    throw new Exception("O Genero deve ser Romance, Terror ou Comedia");
                }
            this.genero = genero;
        }

        public void insert_movies() {

            try{

                Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
            Scanner input_user = new Scanner(System.in);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println(dtf.format(LocalDateTime.now()));      
            System.out.println("Bem vindo ao cadastro de filmes");

            System.out.println(" Digite o Titulo: ");
            set_titulo(input_user.nextLine());

            System.out.println(" Digite Duracao: ");
            set_duracao(input_user.nextInt());
           
            input_user.nextLine();

            System.out.println(" Digite genero: Romance, Terror ou Comedia");            
            set_genero(input_user.nextLine());
           
            System.out.println("Filme: " + get_titulo() + " Duracao: "+ get_duracao() + " Genero: "+ get_genero());
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }

    }            
        
}    

//         public void set_titulo(String titulo)

        


//         public static void cadastro(String[]args)throws Exception{

//             public void insert_movies(){
//             Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
//             Scanner input_user = new Scanner(System.in);

//             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//             System.out.println(dtf.format(LocalDateTime.now()));      
//             System.out.println("Bem vindo ao cadastro de filmes");

//             System.out.println(" Digite o Titulo: ");
//             String nome = input_user.nextLine();

//             System.out.println(" Digite Duracao: ");
//             int tempo = input_user.nextInt();
//             input_user.nextLine();

//             System.out.println(" Digite genero: ");
//             String tipo = input_user.nextLine();
//             }                  
           
//             public static 
//             Filmes input = new Filmes();
//             input.titulo = nome;
//             input.duracao = tempo;
//             input.genero = tipo;

            
//     }

//     public void setFilmes(String nome) throws Exception{
//         if(nome.isEmpty() || nome == null){
//             throw new Exception("Insira o nome:");
//         }
//         this.titulo = nome;                
//     }
// }

