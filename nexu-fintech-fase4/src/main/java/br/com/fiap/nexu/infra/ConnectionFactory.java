package br.com.fiap.nexu.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Fabrica de conexoes com a instancia Oracle da FIAP.
 * Preencha USER e PASSWORD com o seu RM e senha (ou defina as variaveis
 * de ambiente DB_USER e DB_PASSWORD para nao deixar a senha no codigo).
 */
public class ConnectionFactory {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = System.getenv().getOrDefault("DB_USER", "RMXXXXXX");
    private static final String PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "SENHA");

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
