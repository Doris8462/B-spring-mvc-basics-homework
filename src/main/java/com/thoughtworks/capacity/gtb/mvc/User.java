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
    @NotNull(message = "用户名不为空")
    @Pattern(message ="用户名不合法", regexp = "[A-Za-z_0-9]{3,10}$")
    private String username;
    @NotNull(message = "密码是不为空")
    @Size(message ="密码不合法", max=12,min=5)
    private String password;
    @Email(message ="邮箱地址不合法")
    private String email;
}


