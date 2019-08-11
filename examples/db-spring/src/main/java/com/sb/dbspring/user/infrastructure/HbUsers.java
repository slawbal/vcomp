package com.sb.dbspring.user.infrastructure;

import com.sb.dbspring.user.domain.User;
import com.sb.dbspring.user.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HbUsers implements Users {

    private final HbUsersRepository repository;

    @Autowired
    public HbUsers(final HbUsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(final User user) {
        this.repository.save(user);
    }

    @Override
    public Optional<User> get(final String id) {
        return this.repository.findById(UUID.fromString(id));
    }

    @Override
    public Optional<User> findByLogin(final String login) {
        return this.repository.findByLogin(login);
    }
}
