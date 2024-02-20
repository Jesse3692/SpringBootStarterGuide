package com.shiyanlou.springboot.second;

import org.springframework.data.repository.CrudRepository;

/**
 * 继承 CrudRepository
 */
public interface UserTwoRepository extends CrudRepository<UserTwo, Integer> {
}
