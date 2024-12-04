package com.epam.training.virupakshi_dharaneswar_reddy.pojos;

public record CalculatorInput(
        String operatingSystem,
        String provisioningModel,
        String machineType,
        String gpuType,
        String numberOfGpus,
        String localSsd,
        String region,
        String discountOptions
) {}

