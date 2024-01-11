package com.bo.repositories.users;

import com.bo.core.BusinessRuleValidationException;
import com.bo.model.UserJpaModel;
import com.bo.utils.UsersUtils;
import com.bo.model.User;
import com.bo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class UserCrudRepositoryImpl implements IUserRepository {
    @Autowired
    private IUserCrudRepository userRepository;

    @Override
    public UUID update(User user) throws BusinessRuleValidationException {
        User users = new User(user.getUsername(), user.getEmail(), user.getPass(), user.getAccountType(), user.getPersonId());
        UserJpaModel model = UsersUtils.userToJpaEntity(users);
        return userRepository.save(model).getId();
    }

    @Override
    public User getById(UUID id) {
        try {
            UserJpaModel jpaModel = userRepository.findById(id).orElse(null);
            if(jpaModel == null) throw new BusinessRuleValidationException("Error");
            return UsersUtils.jpaToUser(jpaModel);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
        List<UserJpaModel> jpaModels = Streamable.of(userRepository.findAll()).toList();

        List<User> users = new ArrayList<>();
        jpaModels.stream().forEach(item -> {
            try {
                users.add(UsersUtils.jpaToUser(item));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return users;
    }

    public void setUserRepository(IUserCrudRepository userRepository) {
        this.userRepository = userRepository;
    }
}
