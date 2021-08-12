package com.samasat.civalidator.interface_service;

import com.samasat.civalidator.entity.IdentityCard;

public interface IidentityCardService {
    public IdentityCard findById(Long id);
    public IdentityCard findByFullName(String fullName);
    public IdentityCard findByNumCi(String numCi);
}
