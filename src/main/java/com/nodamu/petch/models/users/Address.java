package com.nodamu.petch.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author profnick
 * 3/25/21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String telNumber;
    private String ghanaPostNumber;
    private String addressLine;
}
