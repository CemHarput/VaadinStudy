package com.example.application.views.list;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Status;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;


import java.util.List;


public class ContactForm extends FormLayout {
     TextField firstName = new TextField("First name");
     TextField lastName = new TextField("Last Name");
     EmailField email = new EmailField("Email");
     ComboBox<Status> status = new ComboBox<>("Status");
     ComboBox<Company> company = new ComboBox<>("Company");

     Button save_button = new Button("Save");
     Button delete_button = new Button("Delete");
     Button cancel_button = new Button("Cancel");

     public ContactForm(List<Company> companies,List<Status> statuses) {
          addClassName("contact-form");
          company.setItems(companies);
          company.setItemLabelGenerator(Company::getName);

          status.setItems(statuses);

          status.setItemLabelGenerator(Status::getName);

          add(
                  firstName,
                  lastName,
                  email,
                  company,
                  status,
                  createButtonLayout()
          );


     }

     private Component createButtonLayout() {

          save_button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
          delete_button.addThemeVariants(ButtonVariant.LUMO_ERROR);
          cancel_button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

          save_button.addClickShortcut(Key.ENTER);
          cancel_button.addClickShortcut(Key.ESCAPE);
          return new HorizontalLayout(save_button,delete_button,cancel_button);
     }
}
