package com.nodamu.petch.dto.users;

import com.nodamu.petch.models.users.Address;
import com.nodamu.petch.models.users.Role;

import java.util.Set;

/**
 * @author profnick
 * 3/25/21
 **/
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Address address;
    private boolean isHost;
    private Set<Role> roles;

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }
}
