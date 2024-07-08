package com.opencejav.LibMaster.repository;

import org.springframework.data.mongodb.repository.*;
import com.opencejav.LibMaster.models.User;

public interface UserRepository extends MongoRepository<User, String>{ }