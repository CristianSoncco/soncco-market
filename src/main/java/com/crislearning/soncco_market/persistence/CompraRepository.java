package com.crislearning.soncco_market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crislearning.soncco_market.domain.Purchase;
import com.crislearning.soncco_market.domain.repository.PurchaseRepository;
import com.crislearning.soncco_market.persistence.crud.CompraCrudRepository;
import com.crislearning.soncco_market.persistence.entity.Compra;
import com.crislearning.soncco_market.persistence.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseRepository{
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>)compraCrudRepository.findAll());
    }
    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
        .map(client -> purchaseMapper.toPurchases(client));
    }
    @Override
    public Purchase save(Purchase purchase) {
        return purchaseMapper.toPurchase(compraCrudRepository.save(purchaseMapper.toCompra(purchase)));
    }
}
