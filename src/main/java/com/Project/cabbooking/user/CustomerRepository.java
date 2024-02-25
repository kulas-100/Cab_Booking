package com.Project.cabbooking.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <CustomerAccount, Integer>{
    boolean findByCdsId(String cdsId);

//    Optional<CustomerAccount> existsByEmail(String email);

//    boolean existsById(String id);
}
