package com.samasat.civalidator.repository;

import com.samasat.civalidator.entity.IdentityCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IidentityCardRepository extends JpaRepository<IdentityCard, Long> {
    public Optional<IdentityCard> findById(Long id);
    public IdentityCard findByFullName(String fullName);
    public IdentityCard findByNumCi (String numCi);
}
