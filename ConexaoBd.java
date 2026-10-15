
package com.mycompany.comercio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBd{
    
           
    private static final String URL = "";
    private static final String USUARIO = "";
    private static final String SENHA = "";
    
    
    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException msg_erro) {
            throw new SQLException("Driver MySQL não encontrado", msg_erro);
        }
    }
    
    public static void testarConexao() {
        try {
            Connection conn = conectar();
            System.out.println("->  Banco de dados conectado!");
            conn.close();
        } catch (SQLException msg_erro) {
            System.out.println("[ ! ] Erro de conexão: " + msg_erro.getMessage());
        }
    }


    
}
