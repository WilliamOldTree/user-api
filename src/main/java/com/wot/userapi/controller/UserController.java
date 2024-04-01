package com.wot.userapi.controller;

import com.wot.userapi.domain.dto.UserDTO;
import com.wot.userapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping({"/{id}"})
    public UserDTO getUserId(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO newUser(@RequestBody @Valid UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping("/{txId}/txId")
    public UserDTO findByTxId(@PathVariable String txId){
        return userService.findByTxId(txId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws UserPrincipalNotFoundException {
        userService.delete(id);
    }

    @GetMapping("/search")
    public List<UserDTO> queryByName(@RequestParam(name="nome", required = true) String nome){
        return userService.queryByName(nome);
    }

    @PatchMapping("{id}")
    public UserDTO userUpdate(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.editUser(id, userDTO);
    }
    @GetMapping("/pageable")
    public Page<UserDTO> getUserPage(Pageable pageable){
        return userService.getAllPage(pageable);
    }

}//end class



























