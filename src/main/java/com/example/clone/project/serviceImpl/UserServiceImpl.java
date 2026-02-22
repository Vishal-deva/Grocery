package com.example.clone.project.serviceImpl;

import com.example.clone.project.dto.ResponseDto;
import com.example.clone.project.dto.UserDto;
import com.example.clone.project.entity.UserEntity;
import com.example.clone.project.repository.UserRepository;
import com.example.clone.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseDto saveOrupdateCustomerDetails(UserDto userDto) {
        ResponseDto response = new ResponseDto();
        try {

            if (userDto.getCustomerId() == null) {

                if (userRepository.findByCustomerEmailId(userDto.getCustomerEmailId()).isPresent()) {
                    response.setStatusMessage("Email Id already exists!");
                    response.setStatusCode("409");
                    return response;
                }

                if (userRepository.findByCustomerMobileNumber(userDto.getCustomerMobileNumber()).isPresent()) {
                    response.setStatusMessage("Mobile number already exists!");
                    response.setStatusCode("409");
                    return response;
                }

                UserEntity user = new UserEntity();
                user.setCustomerName(userDto.getCustomerName());
                user.setCustomerMobileNumber(userDto.getCustomerMobileNumber());
                user.setCustomerEmailId(userDto.getCustomerEmailId());
                user.setCustomerAddress(userDto.getCustomerAddress());
                user.setCustomerPinCode(userDto.getCustomerPinCode());

                userRepository.save(user);

                response.setStatusMessage("Customer Details Saved Successfully");
                response.setStatusCode("200");
                return response;
            } else {
                Optional<UserEntity> userOpt = userRepository.findById(userDto.getCustomerId());

                if (userOpt.isEmpty()) {
                    response.setStatusMessage("Customer Not Found");
                    response.setStatusCode("404");
                    return response;
                }

                UserEntity user = userOpt.get();

                // Check if email is changed & duplicate
                if (!user.getCustomerEmailId().equals(userDto.getCustomerEmailId())
                        && userRepository.findByCustomerEmailId(userDto.getCustomerEmailId()).isPresent()) {
                    response.setStatusMessage("Email Id already exists!");
                    response.setStatusCode("409");
                    return response;
                }

                // Check if mobile is changed & duplicate
                if (!user.getCustomerMobileNumber().equals(userDto.getCustomerMobileNumber())
                        && userRepository.findByCustomerMobileNumber(userDto.getCustomerMobileNumber()).isPresent()) {
                    response.setStatusMessage("Mobile number already exists!");
                    response.setStatusCode("409");
                    return response;
                }

                // Update details
                user.setCustomerName(userDto.getCustomerName());
                user.setCustomerMobileNumber(userDto.getCustomerMobileNumber());
                user.setCustomerEmailId(userDto.getCustomerEmailId());
                user.setCustomerAddress(userDto.getCustomerAddress());
                user.setCustomerPinCode(userDto.getCustomerPinCode());

                userRepository.save(user);

                response.setStatusMessage("Customer Details Updated Successfully");
                response.setStatusCode("200");
                return response;
            }
        } catch (Exception e) {
            response.setStatusMessage("Something went wrong: " + e.getMessage());
            response.setStatusCode("500");
            return response;
        }
    }

    @Override
    public ResponseDto loginUser(UserDto userDto, HttpSession session) {
        ResponseDto response = new ResponseDto();

        try {
            Optional<UserEntity> userLogin = userRepository
                    .findByCustomerEmailIdAndCustomerPassword(
                            userDto.getCustomerEmailId(),
                            userDto.getCustomerPassword()
                    );

            if (userLogin.isPresent()) {
                // ✅ Store user in session
                session.setAttribute("loggedInUser", userLogin.get());
                response.setStatusMessage("Welcome " + userLogin.get().getCustomerName());
                response.setStatusMessage(userLogin.get().getCustomerId());
                response.setStatusCode("200");
            } else {
                response.setStatusMessage("Incorrect Email or Password");
                response.setStatusCode("401");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    @Override
    public UserDto getUserDetails(String customerEmailID) {

        if (customerEmailID == null || customerEmailID.isBlank()) {
            throw new IllegalArgumentException("Customer Email ID cannot be null or empty");
        }

        Optional<UserEntity> userOpt =
                userRepository.findByCustomerEmailId(customerEmailID);

        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found with email: " + customerEmailID);
        }

        UserEntity userEntity = userOpt.get();

        UserDto userDto = new UserDto();
        userDto.setCustomerId(userEntity.getCustomerId());
        userDto.setCustomerName(userEntity.getCustomerName());
        userDto.setCustomerMobileNumber(userEntity.getCustomerMobileNumber());

        return userDto;
    }
}

