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
    private Integer qtdTotalAulas;
    private Integer frequenciaMin;
    private Integer qtdAvaliacoes;
    private String observacoes;
    private int visible = 0;
    private String codUsuario;

    public Sala( String nomeSala, String instituição, String materia, String anoEnsino, Integer qtdTotalAulas, Integer frequenciaMin,Integer qtdAvaliacoes, String observacoes, int visible) {
        this.nomeSala = nomeSala;
        this.instituição = instituição;
        this.materia = materia;
        this.anoEnsino = anoEnsino;
        this.qtdTotalAulas = qtdTotalAulas;
        this.frequenciaMin = frequenciaMin;
        this.qtdAvaliacoes = qtdAvaliacoes;
        this.observacoes = observacoes;
        this.visible = visible;
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
        return qtdTotalAulas;
    }

    public void setQtdTotalAulas(Integer qtdTotalAulas) {
        this.qtdTotalAulas = qtdTotalAulas;
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

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

}//fim da classe
