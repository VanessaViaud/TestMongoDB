package fr.eni.caveavin.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Document("bouteilles")
public class Bouteille {

    @Id
    private String id;
    @Field("nom")
    @Indexed(unique = true)
    @NonNull
    private  String nom;
    @NonNull
    private int millesime;
    private Couleur couleur;
}
