package com.github.edurbs.cleanstock.slices.person;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

@JmixEntity
@Entity
public class Supplier extends Person {
    @Column(name = "NOTES")
    @Lob
    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}