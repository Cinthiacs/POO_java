package package1;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Integers;

// abstract classe pai nao instanciam

public abstract class Item {
    private String  nome;
    private String  descricao;
    private Double  preco;
    private String  codigo;
    private String  categoria;
    private boolean disponivel;

    public Item (   String  nome, 
                    String  descricao, 
                    Double  preco,
                    String  codigo,
                    String  categoria,
                    boolean disponivel){                    
                    this.nome = nome;
                    this.descricao = descricao;
                    this.preco = preco;
                    this.codigo = codigo;
                    this.categoria = categoria;
                    this.disponivel = disponivel;
                }

    public abstract void Detalhes();
    public abstract boolean Create();
    public abstract boolean Read();
    public abstract boolean Update();
    public abstract boolean Delete();

    public String get_nome(){
        return nome;
    }
    public void set_nome(String nome) throws Exception{
        if(nome.isEmpty()|| nome == null){
            throw new Exception("O cadastro 'Nome' é obrigatório");
        }
        this.nome = nome; 
    }
    
    public String get_descricao(){
        return descricao;
    }
    
    public void set_descricao(String descricao) throws Exception{
        if(descricao == null || descricao.isEmpty()){
            throw new Exception("O cadastro 'Descricao' é obrigatório");
        }
        this.descricao = descricao; 
    }

    public Double get_preco(){
        return preco;
    }

    public void set_preco(Double preco) throws Exception{
            if(preco == null || preco < 0){
                throw new Exception("O preço kg deve ser um valor valido separado por ponto");
            }
        this.preco = preco;
    }  
    
    public String get_codigo(){
        return codigo;
    }

    public void set_codigo(String codigo) throws Exception{
        if(codigo == null || codigo.isEmpty()){
            throw new Exception("O cadastro 'Codigo' é obrigatório");
        }
        this.codigo = codigo; 
    }

    public String get_categoria(){
        return categoria;
    }

    public void set_categoria(String categoria) throws Exception{
        if( categoria == null || categoria.isEmpty() ){
            throw new Exception("O cadastro 'Categoria' é obrigatório");
        }
        this.categoria = categoria; 
    }

    public boolean get_disponivel(){
        return disponivel;
    }
    public void set_disponivel(boolean disponivel) throws Exception{
        this.disponivel = disponivel; 
    }
}

