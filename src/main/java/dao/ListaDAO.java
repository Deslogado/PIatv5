package dao;

import com.mycompany.listacompras.Lista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class ListaDAO {

    public void salvar(Lista lista) {

        String sql = "INSERT INTO lista (nome) VALUES (?)";

        try {

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lista_compras",
                "root",
                "1234"
            );

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, lista.getNome());

            stmt.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public ArrayList<Lista> listar() {

        ArrayList<Lista> listas = new ArrayList<>();

        String sql = "SELECT * FROM lista";

        try {

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lista_compras",
                "root",
                "1234"
            );

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Lista lista = new Lista(
                    rs.getInt("id"),
                    rs.getString("nome")
                );

                listas.add(lista);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return listas;
    }
}

