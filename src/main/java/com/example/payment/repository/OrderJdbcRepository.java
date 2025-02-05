package com.example.payment.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public class OrderJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderJdbcRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 연관관계가 있는 table(order_product)의 column을 먼저 삭제
     * mysql은 uuid를 bin으로 저장하기 때문에 UUID_TO_BIN(?)으로 형변환을 해줘야함
     * @param id
     */
    public void deleteById(UUID id) {
        String sql = "DELETE FROM `order` WHERE id = UUID_TO_BIN(?)";
        String sql2 = "DELETE FROM `order_product` WHERE order_id = UUID_TO_BIN(?)";
        jdbcTemplate.update(sql2, id.toString());
        jdbcTemplate.update(sql, id.toString());
    }

    public void paid(UUID id) {
        String sql = "UPDATE `order` SET status = 'PAYMENT_CONFIRMED', paid_at = ? WHERE id = UUID_TO_BIN(?)";
        jdbcTemplate.update(sql, LocalDateTime.now(), id.toString());
    }
}
