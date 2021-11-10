package br.com.ifood;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

    public static Connection obterConexao() {

        Connection conexao = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/restaurantes?useTimezone=true&serverTimezone=UTC",
                    "root",
                    null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conexao;
    }
}
