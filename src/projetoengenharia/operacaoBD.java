package projetoengenharia;

/**
 * Classe para gerar objetos do tipo operacaoBD
 *
 * @author Bruno Lopes
 * @since Classe criada em 06/05/2017
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class operacaoBD {

    //objeto responsavel por armazenar a conexao bd
    Connection con = null;

    //ao construir a classe, sera carregada o driver de conexão 
    public operacaoBD() {
        this.carregarDriver();
    }

    private void carregarDriver() {
        try {
            //tenta carregar o driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Carregado");
        } catch (ClassNotFoundException erro) {
            //se nao carregar o driver
            System.out.println("O driver MySQL não pode ser carregado error:" + erro);

        }
    }

    public Connection obterConexao() {
        try {
            //verifica se conexão fechada ou inexistente
            //abre a conexão
            if (con == null || (con.isClosed())) {
                con = DriverManager.getConnection("jdbc:mysql://localhost/projetoeng", "root", "112845");
                System.out.println("Conexão obtida com sucesso");

            }
        } catch (SQLException erro) {
            System.out.println("SQLException: " + erro);
        } catch (Exception erro) {
            System.out.println("Exception: " + erro);
        }
        return con;
    }

    public void fecharConexao() {
        try {
            if (con != null && (!con.isClosed())) {
                con.close();
                System.out.println("Conexão Encerrada");
            }
        } catch (SQLException erro) {
            System.out.println("Falha no encerramento " + erro);
        }
    }

    public void incluirUsuario(Usuario a) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;
        try {
            String sql = "Insert into usuarios (nome, cpf, rg, email, login, senha) values(?,?,?,?,?,?)";
            pre = conexao.prepareStatement(sql);

            pre.setString(1, a.getNome());
            pre.setString(2, a.getCpf());
            pre.setString(3, a.getRg());
            pre.setString(4, a.getEmail());
            pre.setString(5, a.getLogin());
            pre.setString(6, a.getSenha());

            pre.executeUpdate();
            System.out.println("Inclusão completa com sucesso");
        } catch (Exception erro) {
            System.out.println("erro " + erro);
        }

    }//fim incluir

    public boolean validacaoLogin(String login, String senha) {
        Connection conn = this.obterConexao();
        boolean autenticado = false;
        String sql;
        String loginVer;
        String senhaVer;
        boolean flag = false;

        try {

            //sql = "SELECT login, senha FROM usuarios WHERE login=? and senha=?";
            sql = "SELECT login, senha FROM usuarios";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            //ps.setString(1, login);
            //ps.setString(2, senha);
            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {
                loginVer = rs.getString("login");
                senhaVer = rs.getString("senha");
                autenticado = true;
            } else {
                return autenticado;
            }
        } catch (SQLException erro) {
            System.out.println("erro " + erro);
        }
        return autenticado;
    }
    
    public void incluirSala(Sala a) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;
        try {
            String sql = "Insert into salas (nomeSala, instituicao, materia, anoEnsino, qtdHorasAula, frequenciaMin, qtdAvaliacoes, observacoes) values(?,?,?,?,?,?,?,?)";
            pre = conexao.prepareStatement(sql);

            pre.setString(1, a.getNomeSala());
            pre.setString(2, a.getInstituição());
            pre.setString(3, a.getMateria());
            pre.setString(4, a.getAnoEnsino());
            pre.setInt(5, a.getQtdHorasAula());
            pre.setInt(6, a.getFrequenciaMin());
            pre.setInt(7, a.getQtdAvaliacoes());
            pre.setString(8, a.getObservacoes());

            pre.executeUpdate();
            System.out.println("Inclusão completa com sucesso");
        } catch (Exception erro) {
            System.out.println("erro " + erro);
        }

    }//fim incluir
    
    public void GuardarCodSala(String cod){
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;
        try {
            String sql = "update telaindividual set salacod = ?";
            pre = conexao.prepareStatement(sql);

            pre.setString(1, cod);
            
            pre.executeUpdate();
            System.out.println("Inclusão completa com sucesso");
        } catch (Exception erro) {
            System.out.println("erro " + erro);
        }
    }
       

    public String CodParaTelaIndividual() throws SQLException {
        Connection conn = this.obterConexao();
        String sql;
        String cod="", salacod;
        
        try {

            sql = "select salacod from telaindividual";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            //ps.setString(1, cod);
            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {
                salacod = rs.getString("salacod");
            }
            
        } catch (SQLException erro) {
            System.out.println("erro " + erro);
        }
       
        return cod;
    }//fim alterar

    public void incluirAlunoTelaIndividual(Aluno a, int sala_id) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;
        try {
            String sql = "Insert into alunos (nome, sala_id, dataNascimento, anomeResponsavel, endereco, telefone) values(?,?,?,?,?,?)";
            pre = conexao.prepareStatement(sql);

            pre.setString(1, a.getNome());
            pre.setInt(2, sala_id);
            pre.setString(3, a.getDataNascimento());
            pre.setString(4, a.getNomeResponsavel());
            pre.setString(5, a.getEndereco());
            pre.setInt(6, a.getTelefone());

            pre.executeUpdate();
            System.out.println("Inclusão completa com sucesso");
        } catch (Exception erro) {
            System.out.println("erro " + erro);
        }

    }//fim incluir
    
    
    
    
    
    
    
    public void alterarUsuario(Usuario a) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;

        try {
            String sql = "Update usuarios set nome = ? where codusuarios = ?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, a.getNome());
            pre.setString(2, a.getCodusuario());
            pre.executeUpdate();

            System.out.println("Alteração feita com sucesso");
        } catch (SQLException erro) {
            System.out.println("erro " + erro);
        }
    }//fim alterar

    public void alterarAluguel(Aluguel a) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;

        try {
            String sql = "Update alugueis set nomeusuario = ? , nomelivro = ?, dtdevolucao = ? where codaluguel = ?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, a.getNomeusuario());
            pre.setString(2, a.getNomelivro());
            pre.setString(3, a.getDtdevolucao());
            pre.setString(4, a.getCodaluguel());
            pre.executeUpdate();

            System.out.println("Alteração feita com sucesso");
        } catch (SQLException erro) {
            System.out.println("erro " + erro);
        }
    }//fim alterar

    public void excluirLivro(Livro a) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;

        try {
            String sql = "Delete from livros where codlivro = ?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, a.getCodlivro());
            pre.executeUpdate();

            System.out.println("Exclusão realizada com sucesso");
        } catch (SQLException erro) {
            System.out.println("erro " + erro);
        }
    }// fim excluir    

    public void excluirUsuario(Usuario a) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;

        try {
            String sql = "Delete from usuarios where codusuarios = ?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, a.getCodusuario());
            pre.executeUpdate();

            System.out.println("Exclusão realizada com sucesso");
        } catch (SQLException erro) {
            System.out.println("erro " + erro);
        }
    }// fim excluir

    public void excluirAluguel(Aluguel a) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;

        try {
            String sql = "Delete from alugueis where codaluguel = ?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, a.getCodaluguel());
            pre.executeUpdate();

            System.out.println("Exclusão realizada com sucesso");
        } catch (SQLException erro) {
            System.out.println("erro " + erro);
        }
    }// fim excluir

    public ResultSet listarLivros() {

        Statement st;
        ResultSet rs = null; //representação da memória em uma tabela

        try {
            Connection conexao = this.obterConexao();
            st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //ResultSet.TYPE_SCROLL_SENSITIVE possibilita o acesso 
            //ResultSet.CONCUR_UPDATABLE possibilita a edição
            rs = st.executeQuery("Select * from livros order by cod");
            // executando temporariamente os dados
            System.out.println("Listagem dos livros \n");
            System.out.println("Codigo - Nome - Autor");

            while (rs.next()) {
                System.out.println(rs.getString("cod" + "") + " - " + rs.getString("nome" + "") + " - " + rs.getString("autor" + ""));

            }

            rs.first();
        } catch (Exception erro) {
            System.out.println("erro" + erro);
        }

        return rs;
    }//fim listar

    public ResultSet listarUsuarios() {

        Statement st;
        ResultSet rs = null; //representação da memória em uma tabela

        try {
            Connection conexao = this.obterConexao();
            st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //ResultSet.TYPE_SCROLL_SENSITIVE possibilita o acesso 
            //ResultSet.CONCUR_UPDATABLE possibilita a edição
            rs = st.executeQuery("Select * from usuarios order by cod");
            // executando temporariamente os dados
            System.out.println("Listagem dos usuarios \n");
            System.out.println("Codigo - Nome");

            while (rs.next()) {
                System.out.println(rs.getString("cod" + "") + " - " + rs.getString("nome" + ""));

            }

            rs.first();
        } catch (Exception erro) {
            System.out.println("erro" + erro);
        }

        return rs;
    }//fim listar

    public ResultSet listarAlugueis() {

        Statement st;
        ResultSet rs = null; //representação da memória em uma tabela

        try {
            Connection conexao = this.obterConexao();
            st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //ResultSet.TYPE_SCROLL_SENSITIVE possibilita o acesso 
            //ResultSet.CONCUR_UPDATABLE possibilita a edição
            rs = st.executeQuery("Select * from alugueis order by codaluguel");
            // executando temporariamente os dados
            System.out.println("Listagem dos Alugueis \n");
            System.out.println("Codigo - NomeUsuario - NomeLivro - Data de Devolução");

            while (rs.next()) {
                System.out.println(rs.getString("cod" + "") + " - " + rs.getString("nomeusuario" + "") + " - " + rs.getString("nomelivro" + rs.getString("dtdevolucao" + "") + " - " + ""));

            }

            rs.first();
        } catch (Exception erro) {
            System.out.println("erro" + erro);
        }

        return rs;
    }//fim listar

    public ResultSet buscarLivros(String nome) {

        PreparedStatement st;
        ResultSet rs = null; //representação da memória em uma tabela

        try {
            Connection conexao = this.obterConexao();
            st = conexao.prepareStatement("Select * from alunos where nome like ?");
            st.setString(1, '%' + nome + '%');
            rs = st.executeQuery();
            System.out.println("\n Livros buscados");

            while (rs.next()) {
                System.out.println(rs.getString("codlivro" + "") + " - " + rs.getString("nome" + "") + " - " + rs.getString("Autor" + ""));
            }

            rs.first();
        } catch (Exception erro) {
            System.out.println("erro" + erro);
        }

        return rs;
    }//fim buscar

    public ResultSet buscarUsuarios(String nome) {

        PreparedStatement st;
        ResultSet rs = null; //representação da memória em uma tabela

        try {
            Connection conexao = this.obterConexao();
            st = conexao.prepareStatement("Select * from alunos where nome like ?");
            st.setString(1, '%' + nome + '%');
            rs = st.executeQuery();
            System.out.println("\n Usuarios buscado");

            while (rs.next()) {
                System.out.println(rs.getString("codusuario" + "") + " - " + rs.getString("nome" + "") + "");
            }

            rs.first();
        } catch (Exception erro) {
            System.out.println("erro" + erro);
        }

        return rs;
    }//fim buscar

    public ResultSet buscarAlugueis(String nome) {

        PreparedStatement st;
        ResultSet rs = null; //representação da memória em uma tabela

        try {
            Connection conexao = this.obterConexao();
            st = conexao.prepareStatement("Select * from alunos where nomeusuario like ?");
            st.setString(1, '%' + nome + '%');
            rs = st.executeQuery();
            System.out.println("\n Alugueis buscados");

            while (rs.next()) {
                System.out.println(rs.getString("codaluguel" + "") + " - " + rs.getString("nomeusuario" + "") + " - " + rs.getString("nomelivro" + rs.getString("dtdevolucao") + ""));
            }

            rs.first();
        } catch (Exception erro) {
            System.out.println("erro" + erro);
        }

        return rs;
    }//fim buscar

}//fim da classe
