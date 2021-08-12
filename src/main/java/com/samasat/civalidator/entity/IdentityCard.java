package com.samasat.civalidator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_identity_card")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdentityCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numCi;
    private String fullName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

}
