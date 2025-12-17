package com.github.edurbs.cleanstock.slices.person.ui;

import com.github.edurbs.cleanstock.slices.person.Person;
import com.github.edurbs.cleanstock.slices.person.PersonType;
import com.vaadin.componentfactory.addons.inputmask.InputMask;
import com.vaadin.flow.component.AbstractField;
import io.jmix.flowui.component.datepicker.TypedDatePicker;
import io.jmix.flowui.component.select.JmixSelect;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewComponent;

import java.time.LocalDate;

public abstract class AbstractPersonDetailView<T extends Person> extends StandardDetailView<T> {
    
    @ViewComponent
    protected TypedTextField<String> taxIdField;
    
    @ViewComponent
    protected TypedTextField<String> phoneField;
    
    @ViewComponent
    protected JmixSelect<PersonType> personTypeField;
    
    @ViewComponent
    protected TypedTextField<String> nameField;
    
    @ViewComponent
    protected TypedTextField<String> nickNameField;
    
    @ViewComponent
    protected TypedDatePicker<LocalDate> birthDateField;
    
    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        new InputMask("(00) 0 0000-0000").extend(phoneField);
        personTypeField.setValue(PersonType.INDIVIDUAL);
        setupForIndividualFields(); // Initial setup
    }
    
    @Subscribe("personTypeField")
    public void onPersonTypeFieldComponentValueChange(
            final AbstractField.ComponentValueChangeEvent<JmixSelect<PersonType>, PersonType> event) {
        if (event.getValue() == PersonType.INDIVIDUAL) {
            setupForIndividualFields();
        } else {
            setupForCompanyFields();
        }
    }
    
    protected void setupForIndividualFields() {
        new InputMask("000.000.000-00").extend(taxIdField);
        taxIdField.setMaxLength(14);
        taxIdField.setPlaceholder("000.000.000-00");
        taxIdField.setLabel("CPF");
        taxIdField.setRequiredMessage("CPF é obrigatório");
        
        nameField.setLabel("Nome");
        nickNameField.setLabel("Apelido");
        birthDateField.setLabel("Data de Nascimento");
    }
    
    protected void setupForCompanyFields() {
        taxIdField.setMaxLength(18);
        new InputMask("00.000.000/0000-00").extend(taxIdField);
        taxIdField.setPlaceholder("00.000.000/0000-00");
        taxIdField.setLabel("CNPJ");
        taxIdField.setRequiredMessage("CNPJ é obrigatório");
        
        nameField.setLabel("Razão Social");
        nickNameField.setLabel("Nome Fantasia");
        birthDateField.setLabel("Data de Abertura");
    }
}
