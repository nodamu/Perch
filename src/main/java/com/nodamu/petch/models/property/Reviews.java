package com.nodamu.petch.models.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * @author profnick
 * 3/25/21
 **/

@Data
@NoArgsConstructor
@Document(collection = "Reviews")
public class Reviews {
    @Id
    private String id;
    private String firstName;
    private String comment;
    private LocalDate date;

    public Reviews (String firstName, String comment, LocalDate date) {
        this.firstName = firstName;
        this.comment = comment;
        this.date = date;
    }
}
