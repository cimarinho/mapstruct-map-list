package com.example.mapstructmaplist.mapper;

import com.example.mapstructmaplist.MapeamentoImpl;
import com.example.mapstructmaplist.domain.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;


@Mapper
public interface SimulacaoMapper {

    @Mapping(source = "source1.valorProduto", target = "valorProduto")
    @Mapping(source = "source1.contrato", target = "contrato")
    @Mapping(source = "preco.produto", target = "produto")
    @Mapping(target = "parcelas", ignore = true)
    SimulacaoContratoRequest mapCont(PrecoContratoRequest preco, AjusteContratoRequest source1);


    @Mapping(source = "source1.parcela", target = "parcela")
    @Mapping(source = "source1.valorParcela", target = "valorParcela")
    @Mapping(source = "preco.valorParcelaMaxima", target = "valorParcelaMaxima")
    SimulacaoContratoParcelaRequest map(PrecoContratoParcelaRequest preco, AjusteContratoParcelaRequest source1);

    @AfterMapping
    default SimulacaoContratoRequest map(@MappingTarget SimulacaoContratoRequest simu, PrecoContratoRequest preco, AjusteContratoRequest source1) {
        List<MapeamentoImpl<PrecoContratoParcelaRequest, AjusteContratoParcelaRequest>> result = preco.getParcelas().stream().flatMap(one -> source1.getParcelas().stream()
                .map(two -> new MapeamentoImpl<>(one, two))).collect(Collectors.toList());
        List<SimulacaoContratoParcelaRequest> finalObjects = result.stream()
                .map(p-> map(p.getSource1(),p.getSource2()))
                .collect(Collectors.toList());
        simu.setParcelas(finalObjects);
        return simu;
    }
}
