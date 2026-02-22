package com.example.clone.project.controller;


import com.example.clone.project.dto.ResponseDto;
import com.example.clone.project.dto.UserDto;
import com.example.clone.project.entity.UserEntity;
import com.example.clone.project.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/save-customerDetails")
    public ResponseEntity<ResponseDto>saveOrupdateCustomerDetails(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(userService.saveOrupdateCustomerDetails(userDto));
    }

    @GetMapping("/get-user-details/{email}")
    public ResponseEntity<UserDto> getUserDetails(
            @PathVariable("email") String customerEmailID) {

        return ResponseEntity.ok(userService.getUserDetails(customerEmailID));
    }


    @PostMapping("/login-customer")
    public ResponseEntity<ResponseDto> logiUser(@RequestBody UserDto userDto, HttpSession session) {
        return ResponseEntity.ok(userService.loginUser(userDto, session));
    }

    @GetMapping("/current-customer")
    public ResponseEntity<UserEntity> getCurrentCustomer(HttpSession session) {
        UserEntity customer = (UserEntity) session.getAttribute("loggedInUser");
        if (customer == null) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }




}
