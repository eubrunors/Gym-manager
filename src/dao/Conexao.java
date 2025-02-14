package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/academia";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "java123";

    // Construtor privado para evitar instâncias externas
    private Conexao() {}

    // Método para obter uma nova conexão SEM manter instância fixa (sem Singleton)
    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
