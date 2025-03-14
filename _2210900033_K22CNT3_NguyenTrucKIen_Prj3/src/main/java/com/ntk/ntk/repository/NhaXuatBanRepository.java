package com.ntk.ntk.repository;

import com.ntk.ntk.model.Nhaxuatban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaXuatBanRepository extends JpaRepository<Nhaxuatban, Integer>, JpaSpecificationExecutor<Nhaxuatban> {
}