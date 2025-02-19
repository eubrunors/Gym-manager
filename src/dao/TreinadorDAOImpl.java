package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Treinador;

public class TreinadorDAOImpl implements TreinadorDAO{

	@Override
	public void salvar(Treinador treinador) {
		String sql = "INSERT INTO academia.treinador(nome, sobrenome, cpf, email, telefone, endereco, sala ,treinador_id, ativo) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conexao = Conexao.getConexao();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
        	
            stmt.setString(1, treinador.getNome());
            stmt.setString(2, treinador.getSobrenome());
            stmt.setString(3, treinador.getCpf());
            stmt.setString(4, treinador.getEmail());
            stmt.setString(5, treinador.getTelefone());
            stmt.setString(6, treinador.getEndereco());
            stmt.setInt(7, treinador.getIdTreinador());
            stmt.setDouble(8, treinador.getSalario());

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar treinador: " + e.getMessage(), e);
        }

	}

	@Override
	public void atualizar(Treinador treinador) {
		String sql = "UPDATE academia.treinador SET nome = ?, sobrenome = ?, cpf = ?, email=?, telefone=?, endereco=?,"
				+ "salario=? WHERE idTreinador = ? ";
        try (Connection conexao = Conexao.getConexao();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
        	
            stmt.setString(1, treinador.getNome());
            stmt.setString(2, treinador.getSobrenome());
            stmt.setString(3, treinador.getCpf());
            stmt.setString(4, treinador.getEmail());
            stmt.setString(5, treinador.getTelefone());
            stmt.setString(6, treinador.getEndereco());
            stmt.setInt(7, treinador.getIdTreinador());
            stmt.setDouble(8, treinador.getSalario());

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar treinador: " + e.getMessage(), e);
        }

	}


	@Override
	public void remover(int idTreinador) {
        String sql = "DELETE FROM academia.treinador WHERE idTreinador = ?";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idTreinador);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover treinador: " + e.getMessage(), e);
        }
	}

	@Override
	public Treinador buscarPorIdTreinador(int idTreinador) {
        String sql = "SELECT * FROM treinador WHERE idTreinador = ?";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idTreinador);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return criarTreinador(rs);
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar treinador por Id: " + e.getMessage(), e);
        } 
        return null;
    }


	@Override
	public List<Treinador> listarTodos() {
        String sql = "SELECT * FROM academia.treinador";
        List<Treinador> treinadores = new ArrayList<>();

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
            	treinadores.add(criarTreinador(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os alunos: " + e.getMessage(), e);
        }
        return treinadores;
	}
	
    // Método auxiliar para criar objetos Treinador a partir do ResultSet
    private Treinador criarTreinador(ResultSet rs) throws SQLException {
    	Treinador treinador = new Treinador();
		return treinador;
    }

}
