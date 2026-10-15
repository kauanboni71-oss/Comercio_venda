
package com.mycompany.comercio;

import java.sql.*;
public class VendaConect {

    public void inserir(Venda v) throws SQLException {
        String sql = "INSERT INTO vendas (produto, quantidade, valortotal) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBd.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, v.getProduto());
            stmt.setInt(2, v.getQuantidade());
            stmt.setDouble(3, v.getValorTotal());
            stmt.executeUpdate();
        }
    }

    public double somarTotal() throws SQLException {
        String sql = "SELECT SUM(valortotal) AS total FROM vendas";
        try (Connection conn = ConexaoBd.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) return rs.getDouble("total");
            return 0;
        }
    }
    
    
    public void limparVendas() throws SQLException {
    String sql = "DELETE FROM vendas";
    try (Connection conn = ConexaoBd.conectar();
         Statement stmt = conn.createStatement()) {
        stmt.executeUpdate(sql);
    }
}

}
