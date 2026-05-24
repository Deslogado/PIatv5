package dao;

import com.mycompany.listacompras.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class ItemDAO {

    public void salvar(Item item) {

        String sql =
            "INSERT INTO item(nome, quantidade, marca_fornecedor, comprado) VALUES (?, ?, ?, ?)";

        try {

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lista_compras",
                "root",
                "1234"
            );

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(1, item.getNome());
            stmt.setInt(2, item.getQuantidade());
            stmt.setString(3, item.getMarcaFornecedor());
            stmt.setBoolean(4, false);

            stmt.executeUpdate();

            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public ArrayList<Item> listar() {

        ArrayList<Item> itens = new ArrayList<>();

        String sql = "SELECT * FROM item";

        try {

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lista_compras",
                "root",
                "1234"
            );

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Item item = new Item(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("quantidade"),
                    rs.getString("marca_fornecedor")
                );

                itens.add(item);
            }

            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return itens;
    }
}

