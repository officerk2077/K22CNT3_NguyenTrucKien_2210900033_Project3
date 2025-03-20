package com.ntk.ntk.repository;

import com.ntk.ntk.model.Baiviet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiVietRepository extends JpaRepository<Baiviet, Integer>, JpaSpecificationExecutor<Baiviet> {
}