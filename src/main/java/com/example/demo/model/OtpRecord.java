package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OtpRecord {

    @Id
    private String username;

    private String otp;

    @CreationTimestamp
    @Column(name = "create_date_time")
    private OffsetDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_date_time")
    private OffsetDateTime updateDateTime;


}
