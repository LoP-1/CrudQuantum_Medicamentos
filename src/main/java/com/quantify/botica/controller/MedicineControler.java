package com.quantify.botica.controller;

import com.quantify.botica.model.Medicine;
import com.quantify.botica.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicine")
public class MedicineControler {

    @Autowired
    private MedicineService medicineService;

    //Obtener los medicamentos
    @GetMapping
    public ResponseEntity<List<Medicine>> ListMedicines() {
        List<Medicine> medicamentos = medicineService.getAllMedicines();
        return new ResponseEntity<>(medicamentos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) {
        //medicina creada y subida
        Medicine createdMedicine = medicineService.saveMedicamento(medicine);
        return new ResponseEntity<>(createdMedicine, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicamentoById(@PathVariable("id") long id) {
        Optional<Medicine> medicamento = medicineService.getMedicamentoById(id);
        return medicamento.map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable("id") long id, @RequestBody Medicine medicine){
        Optional<Medicine> existingMedicine  = medicineService.getMedicamentoById(id);
        if(existingMedicine.isPresent()){
            medicine.setId(id);
            Medicine newMedicine = medicineService.saveMedicamento(medicine);
            return new ResponseEntity<>(newMedicine, HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable("id") long id) {
        Optional<Medicine> medicine = medicineService.getMedicamentoById(id);
        if (medicine.isPresent()) {
            medicineService.deleteMedicamento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
