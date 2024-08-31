package com.quantify.botica.service;

import com.quantify.botica.model.Medicine;
import com.quantify.botica.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {


    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicines(){
        return medicineRepository.findAll();
    }

    public Optional<Medicine> getMedicamentoById(long id) {
        return medicineRepository.findById(id);
    }

    public Medicine saveMedicamento(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public void deleteMedicamento(long id) {
        medicineRepository.deleteById(id);
    }

}
