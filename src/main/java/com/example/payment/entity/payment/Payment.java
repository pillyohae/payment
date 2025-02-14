package com.example.payment.entity.payment;

import com.example.payment.entity.payment.toss_variable.PayMethod;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String mid;
    @Column(nullable = false)
    private String version;
    @Column(nullable = false)
    private String paymentKey;
    @Column
    private String status;
    @Column(nullable = false)
    private UUID orderId;
    @Column
    private String orderName;
    @Column
    private String requestedAt;
    @Column
    private String approvedAt;
    @Column
    private Integer totalAmount;
    @Column
    private Integer balanceAmount;
    @Enumerated(EnumType.STRING)
    @Column
    private PayMethod method;

    // 연관관계 설정은 하지 않습니다

    @Builder
    public Payment(String mid, String version, String paymentKey, String status, UUID orderId, String orderName, String requestedAt, String approvedAt, Integer totalAmount, Integer balanceAmount, PayMethod method) {

        this.mid = mid;
        this.version = version;
        this.paymentKey = paymentKey;
        this.status = status;
        this.orderId = orderId;
        this.orderName = orderName;
        this.requestedAt = requestedAt;
        this.approvedAt = approvedAt;
        this.totalAmount = totalAmount;
        this.balanceAmount = balanceAmount;
        this.method = method;
    }
}
