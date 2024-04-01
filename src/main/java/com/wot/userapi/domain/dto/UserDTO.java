package com.wot.userapi.domain.dto;

import com.wot.userapi.domain.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private String name;
    @NotBlank(message = "Cpf  obrigatorio")
    private String txId;
    private String andress;
    private String email;
    private String phoneNumber;
    private LocalDateTime dateTimeInput;

    public static UserDTO convertDto (User user){

        var userDto = new UserDTO();

        userDto.setName(user.getName());
        userDto.setTxId(user.getTxId());
        userDto.setAndress(userDto.getAndress());
        userDto.setEmail(userDto.getEmail());
        userDto.setPhoneNumber(userDto.getPhoneNumber());
        userDto.setDateTimeInput(user.getDateTimeInput());

        return userDto;

    }


}
