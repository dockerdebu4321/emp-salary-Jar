package com.ey.practice.SpringBootPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.practice.SpringBootPractice.model.VehicleEntity;


@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer>{
	


}
