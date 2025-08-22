package daoimobiliaria;

import imobiliaria.Imovel;
import conexaoimobiliaria.ConexaoImobiliaria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO {
    public void inserir(Imovel i) throws Exception {
        String sql = "INSERT INTO Imovel (endereco, tipo, quartos, valor_aluguel, disponivel) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexaoImobiliaria.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, i.getEndereco());
            ps.setString(2, i.getTipo());
            ps.setInt(3, i.getQuartos());
            ps.setDouble(4, i.getValorAluguel());
            ps.setBoolean(5, i.isDisponivel());
            ps.executeUpdate();
        }
    }

    public List<Imovel> listarTodos() throws Exception {
        List<Imovel> imoveis = new ArrayList<>();
        String sql = "SELECT * FROM Imovel";
        try (Connection con = ConexaoImobiliaria.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Imovel i = new Imovel();
                i.setId(rs.getInt("id"));
                i.setEndereco(rs.getString("endereco"));
                i.setTipo(rs.getString("tipo"));
                i.setQuartos(rs.getInt("quartos"));
                i.setValorAluguel(rs.getDouble("valor_aluguel"));
                i.setDisponivel(rs.getBoolean("disponivel"));
                imoveis.add(i);
            }
        }
        return imoveis;
    }

    public List<Imovel> listarDisponiveis() throws Exception {
        List<Imovel> imoveis = new ArrayList<>();
        String sql = "SELECT * FROM Imovel WHERE disponivel = TRUE";
        try (Connection con = ConexaoImobiliaria.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Imovel i = new Imovel();
                i.setId(rs.getInt("id"));
                i.setEndereco(rs.getString("endereco"));
                i.setTipo(rs.getString("tipo"));
                i.setQuartos(rs.getInt("quartos"));
                i.setValorAluguel(rs.getDouble("valor_aluguel"));
                i.setDisponivel(rs.getBoolean("disponivel"));
                imoveis.add(i);
            }
        }
        return imoveis;
    }

    public void atualizarDisponibilidade(int idImovel, boolean disponivel) throws Exception {
        String sql = "UPDATE Imovel SET disponivel = ? WHERE id = ?";
        try (Connection con = ConexaoImobiliaria.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, disponivel);
            ps.setInt(2, idImovel);
            ps.executeUpdate();
        }
    }

    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM Imovel WHERE id = ?";
        try (Connection con = ConexaoImobiliaria.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
