package projetoengenharia;

/**
 *Classe para gerar objetos do tipo Aluno
 * @author Bruno Lopes
 * @since Classe criada em 10/08/2017
 */
class Aluno {
    private int codAluno;
    private int sala_id;
    private int frequencia;
    private String nome;
    private String dataNascimento;
    private String nomeResponsavel;
    private String endereco; 
    private Integer telefone;
    
    public Aluno(String nome, String dataNascimento, String nomeResponsavel, String endereco, Integer telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nomeResponsavel = nomeResponsavel;
        this.endereco = endereco;
        this.telefone = telefone;
        
    }
    
    
    
    

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }

    public int getSala_id() {
        return sala_id;
    }

    public void setSala_id(int sala_id) {
        this.sala_id = sala_id;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

}//fim da classe
