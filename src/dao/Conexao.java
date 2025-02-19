package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/academia";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "java123";

    // Bloco estático para carregar o driver
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro ao carregar o driver do PostgreSQL!", e);
        }
    }

    // Construtor privado para evitar instâncias externas
    private Conexao() {}

    // Método para obter uma nova conexão
    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
