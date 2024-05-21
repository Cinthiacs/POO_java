package package1;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Integers;

public class Produto extends Item{
    
    private String data_validade;
    private int quantidade;

    public Produto(String nome, String descricao, double preco, String codigo, String categoria, int quantidade, 
                   boolean disponivel, String data_validade) {

        super(nome, descricao, preco, codigo, categoria, disponivel);
        
        this.data_validade = data_validade;
        this.quantidade = quantidade;
    }

    @Override
    public void Detalhes() {
        System.out.println("Produto: " + get_nome());
        System.out.println("Descricao: " + get_descricao());
        System.out.println("Preco: " + get_preco());
        System.out.println("Codigo: " + get_codigo());
        System.out.println("Categoria: " + get_categoria());
        System.out.println("Quantidade em Estoque: " + get_quantidade());
        System.out.println("Disponivel: " + get_disponivel());
        System.out.println("Data de Validade: " + data_validade );
    }

    @Override
    public boolean Create(){
        System.out.println("Create: " + get_nome());
        return true;
    }
    
    @Override
    public boolean Read(){
        System.out.println("Read: " + get_nome());
        return true;
    }
    
    @Override
    public boolean Update(){
        System.out.println("Update: " + get_nome());
        return true;
    }
    
    @Override
    public boolean Delete(){
        System.out.println("Delete: " + get_nome());
        return true;
    }

    public String get_data_validade() {
        return data_validade;
    }

    public void set_data_validade(String data_Validade)throws Exception{
        if(data_Validade ==null || data_Validade.isEmpty()){
            throw new Exception("Valor não pode ser nulo ou vazio");
        }
        this.data_validade = data_Validade;
    }

    public int get_quantidade(){
        return quantidade;
    }

    public void set_quantidade(int quantidade)throws Exception{
        if(quantidade < 0){
            throw new Exception("Quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;
    }  

}
