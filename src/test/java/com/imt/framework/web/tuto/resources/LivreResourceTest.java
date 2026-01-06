package com.imt.framework.web.tuto.resources;

import com.imt.framework.web.tuto.entities.Livre;
import com.imt.framework.web.tuto.repositories.LivreRepository;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LivreResourceTest {

    @Mock
    private LivreRepository livreRepository;

    @InjectMocks
    private LivreResource livreResource;

    @Test
    public void testGetBooks() {
        System.out.println("--------------------------------------------------");
        System.out.println("[DEBUT] Test API : Récupération de tous les livres");

        System.out.println("Simulation : Le repository renvoie une liste vide.");
        Mockito.when(livreRepository.findAll()).thenReturn(Collections.emptyList());

        System.out.println("Appel de la méthode getBooks(null)...");
        Response response = livreResource.getBooks(null);

        System.out.println("Vérification du code de statut HTTP : " + response.getStatus());
        assertEquals(200, response.getStatus());

        System.out.println("[SUCCÈS] L'API répond correctement (200 OK).");
        System.out.println("--------------------------------------------------");
    }

    @Test
    public void testUpdateBookNotFound() {
        System.out.println("--------------------------------------------------");
        System.out.println("[DEBUT] Test API : Mise à jour livre inexistant (Cas d'erreur)");

        Integer idInexistant = 999;
        Livre livreModifie = new Livre();

        System.out.println("Simulation : Recherche de l'ID " + idInexistant + " -> Non trouvé.");
        Mockito.when(livreRepository.findById(idInexistant)).thenReturn(Optional.empty());

        System.out.println("Vérification que l'exception 'Livre inconnu' est bien levée...");
        Exception exception = assertThrows(Exception.class, () -> {
            livreResource.updateBook(idInexistant, livreModifie);
        });

        System.out.println("Message d'erreur capturé : " + exception.getMessage());
        assertEquals("Livre inconnu", exception.getMessage());

        System.out.println("[SUCCÈS] L'erreur est correctement gérée par l'API.");
        System.out.println("--------------------------------------------------");
    }
}