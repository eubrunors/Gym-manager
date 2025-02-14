package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.Treinador;

public class AlunoDAOImpl implements AlunoDAO {

    @Override
    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO academia.aluno(matricula, objetivo, observacao, treinador_id, ativo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getObjetivo());
            stmt.setString(3, aluno.getObservacao());

            // Verifica se o treinador não é nulo antes de acessar seu ID
            if (aluno.getTreinador() != null) {
                stmt.setInt(4, aluno.getTreinador().getIdTreinador());
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER);
            }

            stmt.setBoolean(5, aluno.isAtivo());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar aluno: " + e.getMessage(), e);
        }
    }

    @Override
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE academia.aluno SET objetivo = ?, observacao = ?, treinador_id = ?, ativo = ? WHERE matricula = ?";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, aluno.getObjetivo());
            stmt.setString(2, aluno.getObservacao());

            if (aluno.getTreinador() != null) {
                stmt.setInt(3, aluno.getTreinador().getIdTreinador());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }

            stmt.setBoolean(4, aluno.isAtivo());
            stmt.setInt(5, aluno.getMatricula());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno: " + e.getMessage(), e);
        }
    }

    @Override
    public void remover(int matricula) {
        String sql = "DELETE FROM academia.aluno WHERE matricula = ?";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, matricula);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover aluno: " + e.getMessage(), e);
        }
    }

    @Override
    public Aluno buscarPorMatricula(int matricula) {
        String sql = "SELECT * FROM academia.aluno WHERE matricula = ?";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, matricula);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return criarAluno(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar aluno por matrícula: " + e.getMessage(), e);
        }

        return null;
    }

    @Override
    public List<Aluno> listarTodos() {
        String sql = "SELECT * FROM academia.aluno";
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                alunos.add(criarAluno(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os alunos: " + e.getMessage(), e);
        }

        return alunos;
    }

    // Método auxiliar para criar objetos Aluno a partir do ResultSet
    private Aluno criarAluno(ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setMatricula(rs.getInt("matricula"));
        aluno.setObjetivo(rs.getString("objetivo"));
        aluno.setObservacao(rs.getString("observacao"));
        aluno.setAtivo(rs.getBoolean("ativo"));

        Treinador treinador = new Treinador();
        treinador.setId(rs.getInt("treinador_id"));

        aluno.setTreinador(treinador);
        return aluno;
    }
}
