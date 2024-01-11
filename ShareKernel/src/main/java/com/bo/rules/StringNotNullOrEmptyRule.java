package com.bo.rules;


import com.bo.core.IBusinessRule;

public class StringNotNullOrEmptyRule implements IBusinessRule {
    public String _value;

    public StringNotNullOrEmptyRule(String value) {
        this._value = value;
    }

    @Override
    public String getMessage(){
        return "string cannot be null";
    }

    public boolean isValid(){
        return _value == null || _value.isEmpty();
    }
}
