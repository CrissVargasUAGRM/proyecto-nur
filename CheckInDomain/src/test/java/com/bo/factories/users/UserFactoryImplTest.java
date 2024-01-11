package com.bo.factories.users;

import com.bo.core.BusinessRuleValidationException;
import com.bo.factories.users.IUserFactory;
import com.bo.factories.users.UserFactoryImpl;
import com.bo.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryImplTest {
    IUserFactory userFactory;

    @BeforeEach
    void setUp() {
        userFactory = new UserFactoryImpl();
    }

    @AfterEach
    void tearDown() {
        userFactory = null;
    }

    @Test
    void testCreateUserFactory() throws BusinessRuleValidationException {
        User user = userFactory.createUser(
                "Criss",
                "cristhian_086@gmail.com",
                "123456",
                "Huesped",
                UUID.randomUUID()
        );
        assertNotNull(user);
        assertNotNull(user.getPersonId());
        assertEquals("Criss", user.getUsername());
        assertEquals("cristhian_086@gmail.com", user.getEmail());
        assertEquals("123456", user.getPass());
        assertEquals("Huesped", user.getAccountType());
        assertNotNull(user.getPersonId());
    }
}