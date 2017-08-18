package projetoengenharia;

/**
 *Classe para gerar objetos do tipo Sala
 * @author Bruno Lopes
 * @since Classe criada em 07/08/2017
 */
public class Sala {
    private String codSala;
    private String nomeSala;
    private String instituição; 
    private String materia;
    private String anoEnsino;
    private Integer qtdHorasAula;
    private Integer frequenciaMin;
    private Integer qtdAvaliacoes;
    private String observacoes;

    public Sala( String nomeSala, String instituição, String materia, String anoEnsino, Integer qtdHorasAula, Integer frequenciaMin,Integer qtdAvaliacoes, String observacoes) {
        this.nomeSala = nomeSala;
        this.instituição = instituição;
        this.materia = materia;
        this.anoEnsino = anoEnsino;
        this.qtdHorasAula = qtdHorasAula;
        this.frequenciaMin = frequenciaMin;
        this.qtdAvaliacoes = qtdAvaliacoes;
        this.observacoes = observacoes;
    }
    
    public Sala(String codSala){
        this.codSala = codSala;
    }

    
    
    
    public String getCodSala() {
        return codSala;
    }

    public void setCodSala(String codSala) {
        this.codSala = codSala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getInstituição() {
        return instituição;
    }

    public void setInstituição(String instituição) {
        this.instituição = instituição;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getAnoEnsino() {
        return anoEnsino;
    }

    public void setAnoEnsino(String anoEnsino) {
        this.anoEnsino = anoEnsino;
    }

    public Integer getQtdHorasAula() {
        return qtdHorasAula;
    }

    public void setQtdHorasAula(Integer qtdHorasAula) {
        this.qtdHorasAula = qtdHorasAula;
    }

    public Integer getFrequenciaMin() {
        return frequenciaMin;
    }

    public void setFrequenciaMin(Integer frequenciaMin) {
        this.frequenciaMin = frequenciaMin;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getQtdAvaliacoes() {
        return qtdAvaliacoes;
    }

    public void setQtdAvaliacoes(Integer qtdAvaliacoes) {
        this.qtdAvaliacoes = qtdAvaliacoes;
    }

}//fim da classe
