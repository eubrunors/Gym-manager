package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/academia";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "java123";

    private static Connection conexao;

    // Construtor privado para evitar instâncias externas
    private Conexao() {}

    // Método para obter conexão (Singleton)
    public static Connection getConexao() {
        if (conexao == null) {
            try {
                // Registrar o driver JDBC (para versões mais antigas do Java, pode não ser necessário)
                Class.forName("org.postgresql.Driver");

                // Criar conexão
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.out.println("✅ Conexão com PostgreSQL estabelecida com sucesso!");

            } catch (ClassNotFoundException e) {
                System.err.println("❌ Driver PostgreSQL não encontrado: " + e.getMessage());

            } catch (SQLException e) {
                System.err.println("❌ Erro ao conectar ao PostgreSQL: " + e.getMessage());
            }
        }
        return conexao;
    }

    // Método para fechar a conexão
    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
                System.out.println("✅ Conexão com PostgreSQL fechada com sucesso!");
            } catch (SQLException e) {
                System.err.println("❌ Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
