package com.feature.repository;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.feature.entity.*;

@Repository
public interface PayeeRepository extends JpaRepository<Payee,Serializable> {

}
