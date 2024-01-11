package com.bo.valueObjects;

import com.bo.core.BusinessRuleValidationException;
import com.bo.core.ValueObject;
import com.bo.rules.ValidEmail;

public class EmailValueObject extends ValueObject {
    public String value;

    public String getValue() {
        return value;
    }

    public EmailValueObject(String value) throws BusinessRuleValidationException {
        checkRule(new ValidEmail(value));
        this.value = value;
    }
}
