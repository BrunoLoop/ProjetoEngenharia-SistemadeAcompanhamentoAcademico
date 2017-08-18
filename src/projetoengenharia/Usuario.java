
package projetoengenharia;

/**
 *Classe para gerar objetos do tipo Usuario
 * @author Bruno Lopes
 * @since Classe criada em 01/08/2017
 * 
 * 
 * anafmaistrob@gmail.com
 * nieduc@fatecourinhos.edu.br
 * 
 * 
 * 
 */
public class Usuario {
    private String codUsuario;
    private String nome;
    private String cpf; 
    private String rg;
    private String email;
    private String login;
    private String senha;
    
    public Usuario(String nome, String cpf, String rg, String email, String login, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }
    
    
    
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

}//fim da classe
