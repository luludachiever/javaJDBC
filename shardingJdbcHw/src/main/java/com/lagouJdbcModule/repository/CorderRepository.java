package com.lagouJdbcModule.repository;

import com.lagouJdbcModule.entity.COrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorderRepository extends JpaRepository<COrder, Long> {
}
