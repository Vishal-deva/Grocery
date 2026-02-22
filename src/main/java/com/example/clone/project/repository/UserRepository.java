package com.example.clone.project.repository;

import com.example.clone.project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByCustomerName(String customerName);

    Optional<UserEntity> findByCustomerEmailId(String customerEmailId);

    Optional<UserEntity> findByCustomerMobileNumber(String customerMobileNumber);

    Optional<UserEntity> findByCustomerEmailIdAndCustomerPassword(String customerEmailId, String customerPassword);

    Optional<UserEntity> findByCustomerEmailIdAndCustomerPasswordAndCustomerId(String customerEmailId, String customerPassword, String customerId);
}
