package com.chatsystem.dtos.Auth;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersSignupDTO {

    @NotBlank(message = "FirstName is Mandatory")
    private String firstName;

    private String doBirth;

    @NotBlank(message = "LastName is Mandatory")
    private String lastName;

    @NotBlank(message = "Email is Mandatory")
    @Pattern(regexp = "^[\\w\\.-]+@gmail\\.com$", message = "Email must be a valid @gmail.com address")
    private String email;
    
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
