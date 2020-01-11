package com.example.mapstructmaplist.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AjusteContratoRequest {

    private Long produto;

    private Long contrato;

    private Double valorProduto;

    private List<AjusteContratoParcelaRequest> parcelas;
}
