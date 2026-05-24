package dao;

import com.mycompany.listacompras.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaItemDAO {

    
public ArrayList<Item> listarItensDaLista(int listaId) {

    ArrayList<Item> itens = new ArrayList<>();

    String sql =
        "SELECT i.id, i.nome, li.quantidade, i.marca_fornecedor, li.comprado " +
        "FROM lista_item li " +
        "JOIN item i ON li.item_id = i.id " +
        "WHERE li.lista_id = ?";

    try {

        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/lista_compras",
            "root",
            "1234"
        );

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, listaId);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Item item = new Item(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("quantidade"),
                    rs.getString("marca_fornecedor")
            );

            item.setComprado(rs.getBoolean("comprado"));

            itens.add(item);
        }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return itens;
    }

    public void salvar(
        int listaId,
        int itemId,
        int quantidade
) {

    String sql =
        "INSERT INTO lista_item(lista_id, item_id, quantidade, comprado) VALUES (?, ?, ?, ?)";

    try {

        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/lista_compras",
            "root",
            "1234"
        );

        PreparedStatement stmt =
                conn.prepareStatement(sql);

        stmt.setInt(1, listaId);
        stmt.setInt(2, itemId);
        stmt.setInt(3, quantidade);
        stmt.setBoolean(4, false);

        int linhas = stmt.executeUpdate();

        System.out.println("SALVOU: " + linhas);

        conn.close();

    } catch (SQLException e) {

        System.out.println("ERRO AO SALVAR NA LISTA_ITEM");
        e.printStackTrace();
    }
}

public void atualizarStatus(
        int listaId,
        int itemId,
        boolean comprado
) {

    String sql =
        "UPDATE lista_item SET comprado = ? WHERE lista_id = ? AND item_id = ?";

    try {

        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/lista_compras",
            "root",
            "1234"
        );

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setBoolean(1, comprado);
        stmt.setInt(2, listaId);
        stmt.setInt(3, itemId);

        stmt.executeUpdate();

        conn.close();

    } catch (SQLException e) {

        e.printStackTrace();
    }
}
}
