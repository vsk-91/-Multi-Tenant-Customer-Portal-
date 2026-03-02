package com.vsk.mtcs.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsk.mtcs.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByTenantId(Long tenantId);
}
