package fr.eni.caveavin.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Document("bouteilles")
//voir à compléter ci-dessous pour avec un index unique pour une grappe complète
//@CompoundIndex(
//        name = "unique_nom_millesime_region",
//        def = "{'nom': 1, 'millesime': 1, 'region.name': 1}",
//        unique = true
//)
public class Bouteille {

    @Id
    private String id;
    @Field("nom")
    @Indexed(unique = true)
    @NonNull
    private  String nom;
    @NonNull
    private int millesime;

    // on peut aussi créer une assocation avec ici @DocumentReference si Region est bien aussi
    //une collection avec @Document.
    private Region region;
    private Couleur couleur;
}
