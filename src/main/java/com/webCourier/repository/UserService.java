package com.webCourier.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webCourier.model.UserModel;
@Repository
public interface UserService extends CrudRepository<UserModel,Long> {}