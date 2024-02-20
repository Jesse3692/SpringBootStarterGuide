package com.shiyanlou.springboot.first;

import org.springframework.data.repository.CrudRepository;

/**
 * 继承 CrudRepository
 */
public interface UserOneRepository extends CrudRepository<UserOne, Integer> {
}
