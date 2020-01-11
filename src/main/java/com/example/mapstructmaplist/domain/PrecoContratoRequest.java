package com.example.mapstructmaplist.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrecoContratoRequest {

    private Long produto;

    private Long contrato;

    private Double valorProduto;

    private List<PrecoContratoParcelaRequest> parcelas;


}
