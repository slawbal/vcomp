package com.sb.dbspring.user.domain;

import java.util.Optional;

public interface Users {

    void save(User user);

    Optional<User> get(String id);

    Optional<User> findByLogin(String login);
}
