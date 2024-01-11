package com.bo.repositories.users;

import com.bo.model.UserJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserCrudRepository extends JpaRepository<UserJpaModel, UUID> {
}
