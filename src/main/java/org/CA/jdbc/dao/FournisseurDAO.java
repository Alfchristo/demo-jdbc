package org.CA.jdbc.dao;

import org.CA.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDAO {

    List<Fournisseur> extraire() throws SQLException;
    void insert(Fournisseur fournisseurACreer) throws Exception;
    int update (String ancienNom, String nouveauNom);
    boolean delete(Fournisseur fournisseur);
}