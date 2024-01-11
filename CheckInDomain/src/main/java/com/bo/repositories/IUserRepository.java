package com.bo.repositories;

import com.bo.core.BusinessRuleValidationException;
import com.bo.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserRepository {
    UUID update(User user) throws BusinessRuleValidationException;
    User getById(UUID id);
    List<User> getAll();
}
