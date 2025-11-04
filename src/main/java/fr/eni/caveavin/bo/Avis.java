package fr.eni.caveavin.bo;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
//@Document("avis")
public class Avis {

//    @Id
//    private String id;
    @NonNull
    private String commentaire;
}
