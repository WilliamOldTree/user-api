package com.wot.userapi.domain.entity;

import com.wot.userapi.domain.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String txId;
    private String andress;
    private String email;
    private String phoneNumber;
    private LocalDateTime dateTimeInput;

    public static User convertUser (UserDTO userDTO){

        var user = new User();
        user.setName(userDTO.getName());
        user.setTxId(userDTO.getTxId());
        user.setAndress(userDTO.getAndress());
        user.setEmail(user.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setDateTimeInput(userDTO.getDateTimeInput());

        return user;
    }

}
