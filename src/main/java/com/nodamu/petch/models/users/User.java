package com.nodamu.petch.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * @author profnick
 * 3/17/21
 **/

@Data
@NoArgsConstructor
@Document(collation = "Users")
public class User {
        @Id
        private String id;

        private String firstName;

        private String lastName;

        @Indexed(unique = true, direction = IndexDirection.DESCENDING)
        private String email;

        private String password;

        private Address address;

        @DBRef
        private Set<Role> roles;

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }
}
