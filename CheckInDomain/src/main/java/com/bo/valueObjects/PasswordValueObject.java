package com.bo.valueObjects;

import com.bo.core.BusinessRuleValidationException;
import com.bo.core.ValueObject;
import com.bo.rules.StringNotNullOrEmptyRule;

public class PasswordValueObject extends ValueObject {
    public String value;

    public String getValue() {
        return value;
    }

    public PasswordValueObject(String value) throws BusinessRuleValidationException {
        checkRule(new StringNotNullOrEmptyRule(value));
        this.value = value;
    }
}
