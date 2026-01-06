package com.imt.framework.web.tuto.repositories;

import com.imt.framework.web.tuto.entities.Livre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class LivreRepositoryTest {

    @Autowired
    private LivreRepository livreRepository;

    @Test
    public void testGetBooksWithMaxPrice() {
        System.out.println("--------------------------------------------------");
        System.out.println("[DEBUT] Test Repository : Requête Prix Maximum");
        System.out.println("--------------------------------------------------");

        System.out.println("ÉTAPE 1 : Insertion de données fictives dans la base H2...");

        Livre l1 = new Livre();
        l1.setTitre("Livre Pas Cher");
        l1.setPrice(10.0);

        Livre l2 = new Livre();
        l2.setTitre("Livre Cher");
        l2.setPrice(50.0);

        livreRepository.save(l1);
        livreRepository.save(l2);
        System.out.println(" -> Inseré : 'Livre Pas Cher' (10.0 euro)");
        System.out.println(" -> Inseré : 'Livre Cher' (50.0 euro)");

        Double limitePrix = 20.0;
        System.out.println("ÉTAPE 2 : Exécution de getBooksWithMaxPrice(" + limitePrix + ")...");
        List<Livre> result = livreRepository.getBooksWithMaxPrice(limitePrix);

        System.out.println("ÉTAPE 3 : Analyse des résultats...");
        System.out.println(" -> Nombre de livres trouvés : " + result.size());

        assertEquals(1, result.size(), "On ne devrait trouver qu'un seul livre en dessous de 20 euro");
        assertEquals("Livre Pas Cher", result.get(0).getTitre());

        System.out.println(" [OK] Le filtre de prix fonctionne parfaitement.");
        System.out.println("--------------------------------------------------");
        System.out.println("[SUCCÈS] La couche Repository est validée.");
        System.out.println("--------------------------------------------------");
    }
}