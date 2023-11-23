package org.CA.jdbc.dao;

import org.CA.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDAO {

    List<Fournisseur> extraire() throws SQLException;
    void insert(Fournisseur fournisseurACreer) throws SQLException;

    int update(String ancienNom, String nouveauNom) throws SQLException;

    boolean delete(Fournisseur fournisseur) throws SQLException;
}