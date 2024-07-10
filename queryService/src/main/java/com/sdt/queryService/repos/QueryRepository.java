package com.sdt.queryService.repos;

import com.sdt.queryService.models.Queries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryRepository  extends JpaRepository<Queries, Integer> {
}
