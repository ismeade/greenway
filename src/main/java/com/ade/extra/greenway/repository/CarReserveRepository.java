package com.ade.extra.greenway.repository;

import com.ade.extra.greenway.repository.entity.CarReserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarReserveRepository extends JpaRepository<CarReserve, Long> {
}
