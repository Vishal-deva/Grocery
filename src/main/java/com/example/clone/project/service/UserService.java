package com.example.clone.project.service;

import com.example.clone.project.dto.ResponseDto;
import com.example.clone.project.dto.UserDto;
import jakarta.servlet.http.HttpSession;

public interface UserService {
    ResponseDto saveOrupdateCustomerDetails(UserDto userDto);

    ResponseDto loginUser(UserDto userDto, HttpSession session);

    UserDto getUserDetails(String customerEmailID);
}
