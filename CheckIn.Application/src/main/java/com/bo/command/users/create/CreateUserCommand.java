package com.bo.command.users.create;

import an.awesome.pipelinr.Command;
import com.bo.dtos.UsersDTO;

public class CreateUserCommand implements Command<UsersDTO> {
    UsersDTO usersDTO;

    public CreateUserCommand(UsersDTO userDTO){
        this.usersDTO = userDTO;
    }
}
