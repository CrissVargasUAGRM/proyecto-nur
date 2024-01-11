package com.bo.util;

import com.bo.core.BusinessRuleValidationException;
import com.bo.dtos.UsersDTO;
import com.bo.model.User;

import java.util.UUID;

public class UserMapper {
    public static UsersDTO from(User user){
        if(user == null) return new UsersDTO();
        return new UsersDTO(
                user.getId().toString(),
                user.getUsername(),
                user.getEmail(),
                user.getPass(),
                user.getAccountType(),
                user.getPersonId().toString()
        );
    }

    public static User from(UsersDTO user) throws BusinessRuleValidationException {
        return new User(
                UUID.fromString(user.getId()),
                user.getUserName(),
                user.getEmail(),
                user.getSecretPass(),
                user.getAccountType(),
                UUID.fromString(user.getPersonId())
        );
    }
}
