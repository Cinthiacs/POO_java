package package1;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class funcionarios {
    protected String nome_funcionario;
    protected String cpf;
    protected String data_admissao;

    Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);

    public String get_nome_funcionario(){
        return nome_funcionario;
    }

    public void set_nome_funcionario(String nome_funcionario) throws Exception{
        if(nome_funcionario.isEmpty()|| nome_funcionario == null){
            throw new Exception("O Cadastro do Nome é obrigatório");
        }
        this.nome_funcionario = nome_funcionario; 
    }

    public String get_cpf(){
        return cpf;
    }

    public void set_cpf(String cpf) throws Exception{
        if(cpf.isEmpty()|| cpf == null){
            throw new Exception("O Cadastro do CPF é obrigatório");
        }
        this.cpf = cpf; 
    }

    public String get_data_admissao(){
        return data_admissao;
    }

    public void set_data_admissao(String data_admissao) throws Exception{
        if(data_admissao.isEmpty()|| data_admissao == null){
            throw new Exception("O Cadastro do Nome é obrigatório");
        }
        this.data_admissao = data_admissao; 
    }


    // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    // data_admissao date = formatter.parse(data_admissao);
    
}
