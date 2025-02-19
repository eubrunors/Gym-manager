package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

    @Override
    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO academia.aluno (nome, sobrenome, cpf, email, telefone, endereco, matricula, objetivo, observacao, treinador_id, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
        	
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getSobrenome());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getTelefone());
            stmt.setString(6, aluno.getEndereco());
            stmt.setInt(7, aluno.getMatricula());
            stmt.setString(8, aluno.getObjetivo());
            stmt.setString(9, aluno.getObservacao());

            // Verifica se o treinador não é nulo antes de acessar seu ID
            stmt.setInt(10, aluno.getTreinador() != null ? aluno.getTreinador().getIdTreinador() : null);
            
            stmt.setBoolean(11, aluno.isAtivo());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar aluno: " + e.getMessage(), e);
        }
    }

    @Override
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE academia.aluno SET nome=?, sobrenome=?, cpf=?, email=?, telefone=?, endereco=?, objetivo=?, observacao=?, treinador_id=?, ativo=? WHERE matricula=?";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getSobrenome());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getTelefone());
            stmt.setString(6, aluno.getEndereco());
            stmt.setString(7, aluno.getObjetivo());
            stmt.setString(8, aluno.getObservacao());

            // Verifica se o treinador não é nulo antes de acessar seu ID
            stmt.setInt(9, aluno.getTreinador() != null ? aluno.getTreinador().getIdTreinador() : null);

            stmt.setBoolean(10, aluno.isAtivo());
            stmt.setInt(11, aluno.getMatricula());

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
        Aluno aluno = new Aluno(
        		rs.getInt("matricula"),
        		rs.getString("objetivo"),
        		rs.getString("observacao"),
        		null,
        		null, rs.getBoolean("ativo"));

        return aluno;
    }
}
