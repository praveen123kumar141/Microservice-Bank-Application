package com.feature.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feature.Entity.PaymentHistory;

@Repository
public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory,Serializable>{

}
