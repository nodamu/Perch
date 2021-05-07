package com.nodamu.petch.models.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author profnick
 * 3/25/21
 **/

@Data
@NoArgsConstructor
@Document(collation = "Role")
public class Role {
    @Id
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String role;

}
