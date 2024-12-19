package com.mege.stock_system.repositories;

import com.mege.stock_system.models.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierModel, String> {
    @Query(value = "SELECT * FORM suppliers WHERE cnpj=%:cnpj%", nativeQuery = true)
    Optional<SupplierModel> findByCNPJ(@Param("cnpj") Integer cnpj);
}