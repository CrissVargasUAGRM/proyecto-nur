package com.bo.controllers;

import an.awesome.pipelinr.Pipeline;
import com.bo.command.users.create.CreateUserCommand;
import com.bo.dtos.UsersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController("/api/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    final Pipeline pipeline;

    public UserController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/create")
    public UsersDTO createUser(@RequestBody UsersDTO usersDTO){
        CreateUserCommand command = new CreateUserCommand(usersDTO);
        return command.execute(pipeline);
    }
}
