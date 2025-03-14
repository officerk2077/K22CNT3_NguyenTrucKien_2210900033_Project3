package com.ntk.ntk.repository;

import com.ntk.ntk.model.Tacgia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TacGiaRepository extends JpaRepository<Tacgia, Integer>, JpaSpecificationExecutor<Tacgia> {
}
