package com.vsk.mtcs.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.vsk.mtcs.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
