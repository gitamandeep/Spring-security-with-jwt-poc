package com.example.demo.repository;


import com.example.demo.model.OtpRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRecordRepository extends JpaRepository<OtpRecord, String> {
    Optional<OtpRecord> findByUsernameAndOtp(String username, String otp);
}
