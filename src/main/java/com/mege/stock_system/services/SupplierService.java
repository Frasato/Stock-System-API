package com.mege.stock_system.services;

import com.mege.stock_system.models.SupplierModel;
import com.mege.stock_system.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierModel> findAllSupplier(){
        return supplierRepository.findAll();
    }

    public boolean saveSupplier(SupplierModel supplier){
        Optional<SupplierModel> findedSupplier = supplierRepository.findByCNPJ(supplier.getCnpj());

        if(findedSupplier.isEmpty()){
            supplierRepository.save(supplier);
            return true;
        }

        return false;
    }

    public boolean deleteSupplier(String id){
        Optional<SupplierModel> findedSupplier = supplierRepository.findById(id);

        if(findedSupplier.isPresent()){
            supplierRepository.delete(findedSupplier.get());
            return true;
        }

        return false;
    }
}