package com.bo.command.users.create;

import an.awesome.pipelinr.Command;
import com.bo.dtos.UsersDTO;
import com.bo.util.UserMapper;
import com.bo.factories.users.IUserFactory;
import com.bo.factories.users.UserFactoryImpl;
import com.bo.model.User;
import com.bo.repositories.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserHandler implements Command.Handler<CreateUserCommand, UsersDTO> {
    private final IUserRepository userRepository;
    private final IUserFactory userFactory;

    public CreateUserHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.userFactory = new UserFactoryImpl();
    }

    @Override
    public UsersDTO handle(CreateUserCommand command) {
        User user = null;
        try {
            user = userFactory.createUser(command.usersDTO.getUserName(), command.usersDTO.getEmail(), command.usersDTO.getSecretPass(), command.usersDTO.getAccountType(), UUID.fromString(command.usersDTO.getPersonId()));
            if(user == null) return null;
            userRepository.update(user);
            return UserMapper.from(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
