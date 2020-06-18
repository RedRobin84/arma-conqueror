package com.redrobin.armaconqueror.security.repository;

import com.redrobin.armaconqueror.web.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
