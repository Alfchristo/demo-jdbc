package org.CA.jdbc.dao.jdbc;

import org.CA.jdbc.dao.FournisseurDAO;
import org.CA.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDAOJDBC implements FournisseurDAO {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        System.out.println("Bloc static");
        ResourceBundle bundle = ResourceBundle.getBundle(
                "database");
        DB_URL= bundle.getString("db.url");
        DB_USER = bundle.getString( "db.user");
        DB_PWD = bundle.getString ("db.password");
    }

    private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES ('%s')";

    @Override
    public List<Fournisseur> extraire() throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        String sql = "SELECT * FROM FOURNISSEUR";

        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
            PreparedStatement pst = cnx.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                Fournisseur itemFournisseur = new Fournisseur(id, nom);
                fournisseurs.add(itemFournisseur);
            }
            rs.close();
            pst.close();
        }
        return fournisseurs;
    }

    @Override
    public void insert(Fournisseur fournisseurACreer) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
            PreparedStatement pst = connection.prepareStatement(INSERT_QUERY);
            pst.setString(1, fournisseurACreer.getNom());
            pst.executeUpdate();
            pst.close();
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
            String sqlUpdate = "UPDATE FOURNISSEUR SET nom = ? WHERE ID = ?";
            PreparedStatement pst = cnx.prepareStatement(sqlUpdate);
            pst.setString(1, nouveauNom);
            pst.setString(2, ancienNom);
            pst.setInt(2, 4); // Replace with actual ID value
            int updatedName = pst.executeUpdate();
            pst.close();
            return updatedName;
        }
    }



    private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = ?";

@Override
    public boolean delete(Fournisseur fournisseur) throws SQLException {
            try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
                PreparedStatement pst = cnx.prepareStatement(DELETE_QUERY);
                pst.setString(1, fournisseur.getNom());
                pst.executeUpdate();
                pst.close();
            }
    return false;
}
    }





