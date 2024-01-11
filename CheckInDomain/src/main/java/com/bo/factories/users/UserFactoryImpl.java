package com.bo.factories.users;

import com.bo.core.BusinessRuleValidationException;
import com.bo.model.User;

import java.util.UUID;

public class UserFactoryImpl implements IUserFactory{
    @Override
    public User createUser(String username, String email, String password, String accountType, UUID personId) throws BusinessRuleValidationException {
        return new User(username, email, password, accountType, personId);
    }
}
