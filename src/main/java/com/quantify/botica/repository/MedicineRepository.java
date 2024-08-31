package com.quantify.botica.repository;

import com.quantify.botica.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository <Medicine,Long> {
}
