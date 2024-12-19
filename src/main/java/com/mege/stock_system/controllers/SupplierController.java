package com.mege.stock_system.controllers;

import com.mege.stock_system.dtos.RequestSupplierDtos;
import com.mege.stock_system.models.SupplierModel;
import com.mege.stock_system.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/list")
    public ResponseEntity<?> listAllSuppliers(){
        List<SupplierModel> all = supplierService.findAllSupplier();
        return ResponseEntity.status(200).body(all);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSupplier(@RequestBody RequestSupplierDtos requestSupplierDtos){
        SupplierModel supplier = new SupplierModel();
        supplier.setCnpj(requestSupplierDtos.cnpj());
        supplier.setPhoneNumber(requestSupplierDtos.phoneNumber());
        supplier.setAddress(requestSupplierDtos.address());
        supplier.setCity(requestSupplierDtos.city());
        supplier.setState(requestSupplierDtos.state());
        supplier.setCep(requestSupplierDtos.cep());
        supplier.setStateRegistration(requestSupplierDtos.stateRegistration());
        supplier.setSupplierType(requestSupplierDtos.supplierType());

        boolean notAlreadyExist = supplierService.saveSupplier(supplier);

        if(notAlreadyExist){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeSupplier(@RequestParam(name = "id") String id){
        boolean deleted = supplierService.deleteSupplier(id);

        if(deleted){
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).body("User not found!");
    }

}
