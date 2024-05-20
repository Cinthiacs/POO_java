package package1;
import package1.Conn;
import package1.cadastro_hortifrutis;
import package1.cadastro_itens;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
    
public class Horti {
// Protected só é visivel nos pacotes dentro da classe
    protected String nome_produto;
    protected String tipo;
    protected Double preco_kg;

    Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);

        public String get_nome_produto(){
            return nome_produto;
        }

        public void set_nome_produto(String nome_produto) throws Exception{
            if(nome_produto.isEmpty()|| nome_produto == null){
                throw new Exception("Nome do Hortifruti é obrigatório");
            }
            this.nome_produto = nome_produto; 
        }
    
            public String get_tipo(){
                return tipo;
            }
            public void set_tipo(String tipo) throws Exception{
                if(tipo.isEmpty()|| tipo == null || !tipo.equalsIgnoreCase("legumes") && !tipo.equalsIgnoreCase("folhas")){
                    throw new Exception("O tipo inserido nao corresponde legumes ou folhas");
                }
                this.tipo = tipo;
            }
    
            public Double get_preco_kg(){
                return preco_kg;
            }
            public void set_preco_kg(Double preco_kg)throws Exception{
                    if(preco_kg == null && preco_kg < 0){
                        throw new Exception("O preço kg deve ser um valor valido separado por ponto");
                    }
                this.preco_kg = preco_kg;
            }    
}      
    


