package com.github.edurbs.cleanstock.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

@JmixEntity
@Entity
public class Company extends Person {
    @NotBlank
    @Column(name = "CNPJ", length = 15)
    private String cnpj;

    @NotBlank
    @Column(name = "LEGAL_NAME")
    private String legalName;

    @NotBlank
    @Column(name = "TRADING_NAME")
    private String tradingName;

    @Past
    @Column(name = "OPERATION_START_DATE")
    private LocalDate operationStartDate;

    public void setOperationStartDate(LocalDate operationStartDate) {
        this.operationStartDate = operationStartDate;
    }

    public LocalDate getOperationStartDate() {
        return operationStartDate;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}