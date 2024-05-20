package com.miguel.apibiblioteca.repository;

import com.miguel.apibiblioteca.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository< User,Long> {
}
