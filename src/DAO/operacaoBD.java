package DAO;

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
import projetoengenharia.Aluno;
import projetoengenharia.Sala;
import projetoengenharia.Usuario;

public class operacaoBD {

    Connection con = null;

    public operacaoBD() {
        this.carregarDriver();
    }

    private void carregarDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Carregado");
        } catch (ClassNotFoundException erro) {
            System.out.println("O driver MySQL não pode ser carregado error:" + erro);
        }
    }

    public Connection obterConexao() {
        try {
            if (con == null || (con.isClosed())) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoeng", "root", "");
                System.out.println("Conexão obtida com sucesso");
                Statement stm = con.createStatement();
            }
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
    }//fim incluir Usuario

    public boolean validacaoLogin(String login, String senha) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre;
        boolean autenticado = false;
        String sql;
        String loginVer = null;
        String senhaVer = null;
        int id_usuario;
        boolean flag = false;

        try {
            sql = "SELECT login, senha, id_usuario FROM usuarios";
            PreparedStatement ps;
            ps = conexao.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                id_usuario = rs.getInt("id_usuario");

                loginVer = rs.getString("login");
                senhaVer = rs.getString("senha");
                if (login.equals(loginVer)) {
                    if (senha.equals(senhaVer)) {

                        String sql1 = "update telaindividual set usuariocod = ? where id_telaindividual = 1";
                        pre = conexao.prepareStatement(sql1);
                        pre.setInt(1, id_usuario);
                        pre.executeUpdate();
                        System.out.println("usuario cod guardado em telaindividual com sucesso: " + id_usuario);

                        autenticado = true;

                        System.out.println("validacao ok");
                        break;
                    }
                }
            }
        } catch (SQLException erro) {
            System.out.println("erro " + erro);
        }
        return autenticado;
    }

    public void incluirSala(Sala a, int id_usuario) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;
        try {
            String sql = "Insert into salas (nomeSala, instituicao, materia, anoEnsino, qtdHorasAula, frequenciaMin, qtdAvaliacoes, observacoes, visible, id_usuario) values(?,?,?,?,?,?,?,?,?,?)";
            pre = conexao.prepareStatement(sql);

            pre.setString(1, a.getNomeSala());
            pre.setString(2, a.getInstituição());
            pre.setString(3, a.getMateria());
            pre.setString(4, a.getAnoEnsino());
            pre.setInt(5, a.getQtdHorasAula());
            pre.setInt(6, a.getFrequenciaMin());
            pre.setInt(7, a.getQtdAvaliacoes());
            pre.setString(8, a.getObservacoes());
            pre.setInt(9, a.getVisible());
            pre.setInt(10, id_usuario);

            pre.executeUpdate();
            System.out.println("Inclusão completa com sucesso");
        } catch (Exception erro) {
            System.out.println("erro " + erro);
        }

    }//fim incluir

    public void GuardarCodSala(int cod) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;
        try {
            String sql = "update telaindividual set salacod = ? where id_telaindividual = 1";
            pre = conexao.prepareStatement(sql);
            pre.setInt(1, cod);
            pre.executeUpdate();

            System.out.println("Sala cod guardada com sucesso: " + cod);
        } catch (Exception erro) {
            System.out.println("erro " + erro);
        }
    }

    public void GuardarCodAluno(int cod) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;
        try {
            String sql = "update telaindividual set alunocod = ? where id_telaindividual = 1";
            pre = conexao.prepareStatement(sql);
            pre.setInt(1, cod);
            pre.executeUpdate();

            System.out.println("Matricula do Aluno guardada com sucesso: " + cod);
        } catch (Exception erro) {
            System.out.println("erro " + erro);
        }
    }

    public void incluirAlunoTelaIndividual(Aluno a, int sala_id) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;
        try {
            String sql = "Insert into alunos (nome, sala_id, dataNascimento, nomeResponsavel, endereco, telefone, visible) values(?,?,?,?,?,?,?)";
            pre = conexao.prepareStatement(sql);

            pre.setString(1, a.getNome());
            pre.setInt(2, sala_id);
            pre.setString(3, a.getDataNascimento());
            pre.setString(4, a.getNomeResponsavel());
            pre.setString(5, a.getEndereco());
            pre.setString(6, a.getTelefone());
            pre.setInt(7, a.getVisible());

            pre.executeUpdate();
            System.out.println("Inclusão completa com sucesso");
        } catch (Exception erro) {
            System.out.println("erro " + erro);
        }
    }//fim incluir aluno pela tela individual das salas

    public void excluirSala(int salacod) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;

        try {
            String sql = "Update salas set visible = 1 where id_Sala = ?";
            pre = conexao.prepareStatement(sql);
            pre.setInt(1, salacod);
            pre.executeUpdate();

            System.out.println("Sala Não Visivel realizada com sucesso");
        } catch (SQLException erro) {
            System.out.println("erro no apgar sala na operacao bd " + erro);
        }
    }// fim excluir Salas

    public void excluirAluno(int id_aluno) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;

        try {
            String sql = "Update alunos set visible = 1 where id_Alunos = ?";
            pre = conexao.prepareStatement(sql);
            pre.setInt(1, id_aluno);
            pre.executeUpdate();

            System.out.println("Aluno 'Não Visivel' realizada com sucesso");
        } catch (SQLException erro) {
            System.out.println("erro no apgar aluno na operacao bd " + erro);
        }
    }// fim excluir Salas

    public void RealizarChamada(int freq, int id_aluno, int qtdTotalAulas) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre;
        ResultSet rs;
        try {
            String sql1 = "SELECT frequencia FROM alunos where id_Alunos = ?";
            pre = conexao.prepareStatement(sql1);
            pre.setInt(1, id_aluno);
            rs = pre.executeQuery();
            while (rs.next()) {
                int frequencia = rs.getInt("frequencia");
                frequencia = frequencia + freq;
                while (rs.next()) {
                    String sql = "Update alunos set frequencia = ? where id_Alunos = ?";
                    pre = conexao.prepareStatement(sql);
                    pre.setInt(1, frequencia);
                    pre.setInt(2, id_aluno);
                    rs = pre.executeQuery();
                }

                break;
            }

        } catch (Exception erro) {
            System.out.println("erro" + erro);
        }
    }

    public void alterarUsuario(Usuario a) {
        Connection conexao = this.obterConexao();
        PreparedStatement pre = null;

        try {
            String sql = "Update usuarios set nome = ? where codusuarios = ?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, a.getNome());
            pre.setString(2, a.getCodUsuario());
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
