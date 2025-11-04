package fr.eni.caveavin.dal;

import fr.eni.caveavin.bo.Bouteille;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BouteilleRepository extends MongoRepository<Bouteille,Integer> {

    Bouteille findBouteillesByNomContains(String nom);
}
