package com.bo.factories.users;

import com.bo.core.BusinessRuleValidationException;
import com.bo.model.User;

import java.util.UUID;

public interface IUserFactory {
    User createUser(String username, String email, String accountType, String password, UUID personId) throws BusinessRuleValidationException;
}
