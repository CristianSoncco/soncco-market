package com.crislearning.soncco_market.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.crislearning.soncco_market.domain.Purchase;
import com.crislearning.soncco_market.persistence.entity.Compra;

@Mapper(componentModel = "spring",uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
        @Mapping(source = "idCompra",target="purchaseId"),
        @Mapping(source = "idCliente",target="clientId"),
        @Mapping(source = "fecha",target="date"),
        @Mapping(source = "medioPago",target="paymentMethod"),
        @Mapping(source = "comentario",target="comment"),
        @Mapping(source = "estado",target="active"),
        @Mapping(source = "compraProductos",target="items")
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente",ignore = true)
    Compra toCompra(Purchase purchase);
}
