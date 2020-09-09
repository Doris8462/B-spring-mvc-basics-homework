package com.thoughtworks.capacity.gtb.mvc;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    @NotNull(message = "username must not be null")
    @Pattern(regexp = "[A-Za-z_0-9]{3,10}$")
    private String username;
    @NotNull(message = "password must not be null")
    @Size(max=12,min=5)
    private String password;
    @Email
    private String email;
}


