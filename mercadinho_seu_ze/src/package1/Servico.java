package package1;

public class Servico extends Item {

    private int duracao_horas;
    private boolean requer_agendamento;

    // Construtor
    public Servico(String nome, String descricao, double preco, String codigo, String categoria,  
                   boolean disponivel, int duracao_horas, boolean requer_agendamento) {
                    
        super(nome, descricao, preco, codigo, categoria, disponivel);
        
        this.duracao_horas = duracao_horas;
        this.requer_agendamento = requer_agendamento;
    }

    @Override
    public void Detalhes() {
        System.out.println("Servico " + get_nome());
        System.out.println("Descricao: " + get_descricao());
        System.out.println("Preco: " + get_preco());
        System.out.println("Codigo: " + get_codigo());
        System.out.println("Categoria: " + get_categoria());
        System.out.println("Disponivel: " + get_disponivel());
        System.out.println("Duracao em Horas: " + duracao_horas);
        System.out.println("Requer Agendamento: " + requer_agendamento);
    }

    //SQL
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

    public int get_duracao_horas() {
        return duracao_horas;
    }

    public void set_duracao_horas(int duracao_horas) throws Exception{
        if( duracao_horas <= 0 ){
            throw new Exception("O valor deve ser maior que zero");
        }

        this.duracao_horas = duracao_horas;
    }

    public boolean requer_agendamento() {
        return requer_agendamento;
    }

    public void set_requer_agendamento(boolean requer_agendamento) {
        this.requer_agendamento = requer_agendamento;
    }
}