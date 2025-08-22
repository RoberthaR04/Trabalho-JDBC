package daoimobiliaria;

import imobiliaria.Contrato;
import conexaoimobiliaria.ConexaoImobiliaria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {
    public void inserir(Contrato c) throws Exception {
        String sql = "INSERT INTO Contrato (imovel_id, cliente_id, valor, data_inicio, data_fim, ativo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexaoImobiliaria.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getIdImovel());
            ps.setInt(2, c.getIdCliente());
            ps.setDouble(3, c.getValor());
            ps.setDate(4, Date.valueOf(c.getDataInicio()));
            ps.setDate(5, Date.valueOf(c.getDataFim()));
            ps.setBoolean(6, c.isAtivo());
            ps.executeUpdate();
        }
    }

    public List<Contrato> listar() throws Exception {
        List<Contrato> contratos = new ArrayList<>();
        String sql = "SELECT * FROM Contrato";
        try (Connection con = ConexaoImobiliaria.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Contrato c = new Contrato();
                c.setId(rs.getInt("id"));
                c.setIdImovel(rs.getInt("imovel_id"));
                c.setIdCliente(rs.getInt("cliente_id"));
                c.setValor(rs.getDouble("valor"));
                c.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                c.setDataFim(rs.getDate("data_fim").toLocalDate());
                c.setAtivo(rs.getBoolean("ativo"));
                contratos.add(c);
            }
        }
        return contratos;
    }

    // ✅ Novo método para listar apenas contratos ativos
    public List<Contrato> listarAtivos() throws Exception {
        List<Contrato> contratos = new ArrayList<>();
        String sql = "SELECT * FROM Contrato WHERE ativo = true";
        try (Connection con = ConexaoImobiliaria.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Contrato c = new Contrato();
                c.setId(rs.getInt("id"));
                c.setIdImovel(rs.getInt("imovel_id"));
                c.setIdCliente(rs.getInt("cliente_id"));
                c.setValor(rs.getDouble("valor"));
                c.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                c.setDataFim(rs.getDate("data_fim").toLocalDate());
                c.setAtivo(rs.getBoolean("ativo"));
                contratos.add(c);
            }
        }
        return contratos;
    }
}
