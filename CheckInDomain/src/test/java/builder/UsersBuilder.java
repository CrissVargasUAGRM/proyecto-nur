package builder;

import com.bo.core.BusinessRuleValidationException;
import com.bo.model.User;

import java.util.UUID;

public class UsersBuilder {
    public User build() throws BusinessRuleValidationException {
        return new User(
                "Criss",
                "cristhian@gmail.com",
                "123456",
                "Huesped",
                UUID.randomUUID()
        );
    }
}
