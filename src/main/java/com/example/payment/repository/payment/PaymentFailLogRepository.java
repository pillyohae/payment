package com.example.payment.repository.payment;


import com.example.payment.entity.payment.PaymentFailLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentFailLogRepository extends JpaRepository<PaymentFailLog, Long> {
}
