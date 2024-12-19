package com.mege.stock_system.dtos;

import java.time.LocalDateTime;

public record RequestProductDto(
        int barCode,
        String name,
        String mark,
        int quantity,
        String type
) {}