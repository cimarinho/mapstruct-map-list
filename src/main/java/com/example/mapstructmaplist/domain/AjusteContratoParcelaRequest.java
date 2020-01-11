package com.example.mapstructmaplist.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AjusteContratoParcelaRequest {

    private Long parcela;

    private Double valorParcela;

    private Double valorParcelaMaxima;
}
