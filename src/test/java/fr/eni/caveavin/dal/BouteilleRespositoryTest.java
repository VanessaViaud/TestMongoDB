package fr.eni.caveavin.dal;

import com.mongodb.DuplicateKeyException;
import fr.eni.caveavin.bo.Bouteille;
import fr.eni.caveavin.bo.Region;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BouteilleRespositoryTest {
    @Autowired
    private BouteilleRepository bouteilleRepository;

    @Test
    @DisplayName("ajout possible nouvelle bouteille")
    void testAjoutBouteilleCasOk() {
        bouteilleRepository.deleteAll();
        Bouteille bouteille = new Bouteille("Quincy", 2023);
        Region champagne = new Region("Champagne");
        bouteille.setRegion(champagne);

        Bouteille savedBouteille = bouteilleRepository.save(bouteille);

        System.out.println(savedBouteille);

        Bouteille searchBouteille = bouteilleRepository.findBouteillesByNomContains("Quin");

        System.out.println(searchBouteille);

        assertTrue(bouteille.equals(savedBouteille));
        assertTrue(savedBouteille.equals(searchBouteille));
        assertNotNull(savedBouteille);

    }

    @Test
    @DisplayName("ajout bouteille en doublon impossible")
    void testAjoutDoublonBouteille() {
        bouteilleRepository.deleteAll();
        Bouteille bouteille = new Bouteille("Saumur Champigny", 2024);
        Region valDeLoire = new Region("Val de Loire");
        bouteille.setRegion(valDeLoire);
        bouteilleRepository.insert(bouteille);
        Bouteille bouteilleDoublon = new Bouteille("Saumur Champigny", 2024);
        bouteilleDoublon.setRegion(valDeLoire);
        try {
            bouteilleRepository.insert(bouteilleDoublon);
            fail();
        }
        catch (DuplicateKeyException ignored) {
        }
    }

}
