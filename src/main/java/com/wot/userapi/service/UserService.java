package com.wot.userapi.service;

import com.wot.userapi.domain.dto.UserDTO;
import com.wot.userapi.domain.entity.User;
import com.wot.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<UserDTO> getAllUsers (){

        List<User> users = repository.findAll();
        return  users
               .stream()
               .map(UserDTO::convertDto)
               .collect(Collectors.toList());
    }

    public UserDTO findById (Long id){

        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User no found"));

        return UserDTO.convertDto(user);
    }

    public UserDTO save(UserDTO userDTO){

        userDTO.setDateTimeInput(LocalDateTime.now());
        User user = repository.save(User.convertUser(userDTO));
        return UserDTO.convertDto(user);

    }

    public UserDTO delete (Long id){

        User userDelete = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        repository.delete(userDelete);
        return UserDTO.convertDto(userDelete);
    }

    public UserDTO findByTxId(String txId){

        User user = repository.findByTxId(txId);
        if (user != null){
            return UserDTO.convertDto(user);
        }
        return null;
    }

    public List<UserDTO> queryByName (String name){

        List<User> users = repository.queryByNameLike(name);
        return users
                .stream()
                .map(UserDTO::convertDto)
                .collect(Collectors.toList());
    }

    public UserDTO editUser (Long id, UserDTO userDTO){

        User user =repository.findById(id)
                .orElseThrow(() -> new RuntimeException ("User not found"));

        if(userDTO.getEmail() != null && !userDTO.getEmail().equals(userDTO.getEmail())){
            userDTO.setEmail(user.getEmail());
        }

        if(userDTO.getPhoneNumber() != null && !userDTO.getPhoneNumber().equals(userDTO.getPhoneNumber())){
            userDTO.setPhoneNumber(user.getPhoneNumber());
        }

        if(userDTO.getAndress() != null && userDTO.getAndress().equals(userDTO.getAndress())){
            userDTO.setAndress(user.getAndress());
        }
        user = repository.save(user);

        return UserDTO.convertDto(user);

    }

    public Page<UserDTO> getAllPage (Pageable pageable){

        Page<User> users = repository.findAll(pageable);
        return users.map(UserDTO::convertDto);
    }

}
