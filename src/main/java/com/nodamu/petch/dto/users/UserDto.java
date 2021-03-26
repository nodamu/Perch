package com.nodamu.petch.dto.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nodamu.petch.models.users.Address;
import com.nodamu.petch.models.users.Role;
import lombok.Data;

import javax.validation.constraints.*;

import java.util.Set;

/**
 * @author profnick
 * 3/25/21
 **/

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    @NotNull
    private String firstName;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    @NotNull
    private String lastName;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    @Email
    private String email;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    @NotBlank
    @Size(min = 6, max = 12)
    private String password;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private Address address;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private boolean isHost;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private Set<Role> roles;

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }
}
