package com.bo.rules;


import com.bo.core.IBusinessRule;

public class ValidEmail implements IBusinessRule {
    public String _email;

    public ValidEmail(String _email) {
        this._email = _email;
    }

    @Override
    public boolean isValid() {
        return _email.isEmpty();
    }

    @Override
    public String getMessage() {
        return "Invalid email person";
    }
}
