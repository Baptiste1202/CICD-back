package com.imt.framework.web.tuto.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivreTest {

    @Test
    public void testLivreProperties() {
        System.out.println("--------------------------------------------------");
        System.out.println("[DEBUT] Test Unitaire : Entité Livre");
        System.out.println("--------------------------------------------------");

        System.out.println("ÉTAPE 1 : Création d'une nouvelle instance de Livre...");
        Livre livre = new Livre();

        System.out.println("ÉTAPE 2 : Injection des données de test...");
        String titreTest = "Cloud Architecture";
        Double prixTest = 29.99;

        livre.setTitre(titreTest);
        livre.setPrice(prixTest);
        System.out.println(" -> Titre défini sur : " + titreTest);
        System.out.println(" -> Prix défini sur : " + prixTest + " euro");

        System.out.println("ÉTAPE 3 : Vérification de l'intégrité des données...");

        assertEquals(titreTest, livre.getTitre());
        System.out.println(" [OK] Le titre récupéré est correct.");

        assertEquals(prixTest, livre.getPrice());
        System.out.println(" [OK] Le prix récupéré est correct.");

        System.out.println("--------------------------------------------------");
        System.out.println("[SUCCÈS] L'entité Livre est valide.");
        System.out.println("--------------------------------------------------");
    }
}