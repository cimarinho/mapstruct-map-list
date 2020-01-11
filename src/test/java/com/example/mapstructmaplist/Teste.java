package com.example.mapstructmaplist;

import com.example.mapstructmaplist.domain.*;
import com.example.mapstructmaplist.mapper.SimulacaoMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Teste {

    @Test
    public void teste2() {
        SimulacaoMapper mapper = Mappers.getMapper(SimulacaoMapper.class);
        List<PrecoContratoRequest> lista1 = Arrays.asList(get2());
        List<AjusteContratoRequest> lista2 = Arrays.asList(get1());
        List<MapeamentoImpl<PrecoContratoRequest, AjusteContratoRequest>> result =
                lista1.stream().flatMap(one -> lista2.stream().map(two -> new MapeamentoImpl<>(one, two))).collect(Collectors.toList());

        List<SimulacaoContratoRequest> finalObjects = result.stream()
                .map(p -> mapper.mapCont((PrecoContratoRequest) p.getSource1(), (AjusteContratoRequest) p.getSource2()))
                .collect(Collectors.toList());

        System.out.println();
    }

    AjusteContratoRequest get1() {
        AjusteContratoRequest a = new AjusteContratoRequest();
        a.setProduto(1L);
        a.setValorProduto(12.2);
        a.setContrato(2L);
        AjusteContratoParcelaRequest b = new AjusteContratoParcelaRequest();
        b.setParcela(2L);
        b.setValorParcela(22.3);
        b.setValorParcelaMaxima(33.3);
        a.setParcelas(Arrays.asList(b));
        return a;
    }

    PrecoContratoRequest get2() {
        PrecoContratoRequest a = new PrecoContratoRequest();
        a.setProduto(1L);
        a.setValorProduto(12.2);
        a.setContrato(2L);
        PrecoContratoParcelaRequest b = new PrecoContratoParcelaRequest();
        b.setParcela(32L);
        b.setValorParcela(422.3);
        b.setValorParcelaMaxima(353.3);
        a.setParcelas(Arrays.asList(b));
        return a;
    }
}
