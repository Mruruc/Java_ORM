package com.mruruc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table(name = "access_cards", schema = "public")
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "access_card_pk_sequence_generator")
    @SequenceGenerator(name = "access_card_pk_sequence_generator", allocationSize = 1)
    @Column(name = "card_id")
    private Long cardId;
    @Column(name = "issued_date",nullable = false)
    private LocalDate issuedDate;
    @Column(name = "is_active",nullable = false)
    private Boolean isActive;
    @Column(name = "firm_ware_version")
    private String firmWareVersion;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",unique = true)
    //   @PrimaryKeyJoinColumn
    Employee employee;

    public AccessCard(){}

    public AccessCard(Long cardId, String firmWareVersion, Boolean isActive, LocalDate issuedDate) {
        this.cardId = cardId;
        this.firmWareVersion = firmWareVersion;
        this.isActive = isActive;
        this.issuedDate = issuedDate;
    }

    public AccessCard(LocalDate issuedDate, Boolean isActive, String firmWareVersion) {
        this.issuedDate = issuedDate;
        this.isActive = isActive;
        this.firmWareVersion = firmWareVersion;
    }
}
