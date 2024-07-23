package com.example.demo.service;

import com.example.demo.model.OtpRecord;
import com.example.demo.repository.OtpRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private OtpRecordRepository otpRecordRepository;

    public String generateOtp(String username) {
        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        OtpRecord otpRecord = new OtpRecord(username, otp, OffsetDateTime.now(), OffsetDateTime.now());
        otpRecordRepository.save(otpRecord);
        System.out.println("~~~~~~~~~~~>"+otp);
        return otp;
    }

    public boolean validateOtp(String username, String otp) {
        Optional<OtpRecord> otpRecord = otpRecordRepository.findByUsernameAndOtp(username, otp);
        return otpRecord.isPresent();
    }
}
