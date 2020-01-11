package com.example.mapstructmaplist.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrecoContratoParcelaRequest {


    private Long parcela;

    private Double valorParcela;

    private Double valorParcelaMaxima;
}
