package package1;
import java.util.Locale;
import java.util.Scanner;

public class Laticinios {
    protected String nome_produto;
    protected String tipo;
    protected Double preco_kg;
    protected Double preco_unidade;

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
                if(tipo.isEmpty()|| tipo == null ){
                    throw new Exception("O Campo está vazio, insira um nome");
                }
                this.tipo = tipo;
            }
    
            public Double get_preco_kg(){
                return preco_kg;
            }
            public void set_preco_kg(Double preco_kg)throws Exception{
                    if(preco_kg == null || preco_kg < 0){
                        throw new Exception("O preço kg deve ser um valor valido separado por ponto");
                    }
                this.preco_kg = preco_kg;
            } 
            
            public Double get_preco_unidade(){
                return preco_unidade;
            }
            public void set_preco_unidade(Double preco_unidade)throws Exception{
                    if(preco_unidade == null || preco_unidade < 0){
                        throw new Exception("O preço unidade deve ser um valor valido separado por ponto");
                    }
                this.preco_unidade = preco_unidade;
            }
              
}
