package com.github.edurbs.cleanstock.slices.person;

import com.github.edurbs.cleanstock.slices.person.taxid.ValidTaxId;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "PERSON", indexes = {
        @Index(name = "IDX_PERSON_UNQ", columnList = "TAX_ID", unique = true)
})
@Entity
@ValidTaxId
public class Person {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "PERSON_TYPE", nullable = false)
    @NotNull
    private String personType;

    @NotNull
    @Column(name = "TAX_ID", nullable = false, unique = true, length = 14)
    private String taxId;

    @Size(min = 2)
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Email
    @Column(name = "EMAIL")
    @Nullable
    private String email;

    @Column(name = "NICK_NAME")
    private String nickName;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Nullable
    @Column(name = "PHONE")
    private String phone;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private OffsetDateTime lastModifiedDate;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxId() {
        return taxId;
    }

    public PersonType getPersonType() {
        return personType == null ? null : PersonType.fromId(personType);
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType == null ? null : personType.getId();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OffsetDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}