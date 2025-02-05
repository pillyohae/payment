package com.example.payment.entity.payment;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;


import java.util.UUID;

/**
 * 결제 실패 저장용 로그
 */
@Entity
@Getter
public class PaymentFailLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID traceId;

    @Column(nullable = false)
    private String errorCode;

    @Column(nullable = false)
    private String message;

    public PaymentFailLog(UUID traceId, String errorCode, String message) {
        this.traceId = traceId;
        this.errorCode = errorCode;
        this.message = message;
    }

    protected PaymentFailLog() {

    }
}
