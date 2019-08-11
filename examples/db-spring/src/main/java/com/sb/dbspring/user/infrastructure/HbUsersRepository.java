package com.sb.dbspring.user.infrastructure;

import com.sb.dbspring.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HbUsersRepository extends CrudRepository<User, UUID> {
    Optional<User> findByLogin(String login);
}
