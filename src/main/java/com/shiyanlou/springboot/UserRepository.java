package com.shiyanlou.springboot;

import org.springframework.data.repository.CrudRepository;

/**
 * 继承CrudRepository
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}
