package com.bo.model;

import com.bo.core.AggregateRoot;
import com.bo.core.BusinessRuleValidationException;
import com.bo.valueObjects.EmailValueObject;
import com.bo.valueObjects.PasswordValueObject;

import java.util.UUID;

public class User extends AggregateRoot {
    public String username;

    public String accountType;

    public EmailValueObject email;

    public PasswordValueObject pass;

    public UUID personId;

    public String getUsername() {
        return username;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getEmail() {
        return email.getValue();
    }

    public String getPass() {
        return pass.getValue();
    }

    public UUID getPersonId() {
        return personId;
    }

    public User(String username, String email, String pass, String accountType, UUID personId) throws BusinessRuleValidationException {
        id = UUID.randomUUID();
        this.username = username;
        this.email = new EmailValueObject(email);
        this.pass = new PasswordValueObject(pass);
        this.accountType = accountType;
        this.personId = personId;
    }

    public User(UUID idUser, String username, String email, String pass, String accountType, UUID personId) throws BusinessRuleValidationException {
        id = idUser;
        this.username = username;
        this.email = new EmailValueObject(email);
        this.pass = new PasswordValueObject(pass);
        this.accountType = accountType;
        this.personId = personId;
    }
}
