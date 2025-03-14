package com.ntk.ntk.repository;

import com.ntk.ntk.model.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SachRepository extends JpaRepository<Sach, Integer>, JpaSpecificationExecutor<Sach> {
}
