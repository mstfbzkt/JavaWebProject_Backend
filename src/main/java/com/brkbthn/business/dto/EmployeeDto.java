package com.brkbthn.business.dto;

import com.brkbthn.annotation.EmployeeUniqueEmail;
import com.brkbthn.annotation.EmployeeUniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class EmployeeDto {
    //private Long id;
    @NotNull(message = "{brkbthn.username.validation.constraints.NotNull.message}")
    private String username;

    @NotNull(message = "{brkbthn.email.validation.constraints.NotNull.message}")
    @Email
    @Size
    @EmployeeUniqueEmail
    private String email;

    @Size(min = 7, max = 20)
    @NotNull(message = "{brkbthn.password.validation.constraints.NotNull.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*$", message = "{brkbthn.password.pattern.validation.constraints.NotNull.message}")
    private String pasword;


    private double price;
}
