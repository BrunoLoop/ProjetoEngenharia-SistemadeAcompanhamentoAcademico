/**
 *Classe para gerar objetos do tipo Usuario
 * @author Bruno Lopes
 * @since Classe criada em 01/08/2017
 */
public class Usuario {
    String nome = null;
    String cpf = null; 
    String rg = null;
    String email = null;
    String login = null;
    String senha = null;
    
    public Usuario(String nome, String cpf, String rg, String email, String login, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getCpf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getRg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getSenha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}//fim da classe
