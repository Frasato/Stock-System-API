package com.mege.stock_system.dtos;

public record RequestSupplierDtos(
        int cnpj,
        int phoneNumber,
        String address,
        String city,
        String state,
        int cep,
        String stateRegistration,
        String supplierType
) {}