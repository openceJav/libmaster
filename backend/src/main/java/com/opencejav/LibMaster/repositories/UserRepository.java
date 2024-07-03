package com.opencejav.LibMaster.repositories;

import org.springframework.data.mongodb.repository.*;
import com.opencejav.LibMaster.models.User;

public interface UserRepository extends MongoRepository<User, String>{ }