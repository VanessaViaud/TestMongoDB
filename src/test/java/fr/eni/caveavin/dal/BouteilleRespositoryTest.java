package fr.eni.caveavin.dal;

import fr.eni.caveavin.bo.Bouteille;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BouteilleRespositoryTest {
    @Autowired
    private BouteilleRepository bouteilleRepository;

    @Test
    void testAjoutBouteilleCasOk() {
        Bouteille bouteille = new Bouteille("Quincy", 2023);

        Bouteille savedBouteille = bouteilleRepository.save(bouteille);

        System.out.println(savedBouteille);

        Bouteille searchBouteille = bouteilleRepository.findBouteillesByNomContains("Quin");

        System.out.println(searchBouteille);

        assertTrue(bouteille.equals(savedBouteille));
        assertTrue(savedBouteille.equals(searchBouteille));
        assertNotNull(savedBouteille);

    }
}
