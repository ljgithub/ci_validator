package com.samasat.civalidator.service;


import com.samasat.civalidator.entity.IdentityCard;
import com.samasat.civalidator.interface_service.IidentityCardService;
import com.samasat.civalidator.repository.IidentityCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IdentityService implements IidentityCardService {

    @Autowired
    IidentityCardRepository identityCardRepository;


    @Override
    public IdentityCard findById(Long id) {

        return identityCardRepository.findById(id).orElse(null);
    }

    @Override
    public IdentityCard findByFullName(String fullName) {
        return identityCardRepository.findByFullName(fullName);
    }

    @Override
    public IdentityCard findByNumCi(String numCi) {
        return identityCardRepository.findByNumCi(numCi);
    }
}
