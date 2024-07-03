package com.opencejav.LibMaster.repositories;

import org.springframework.data.mongodb.repository.*;
import com.opencejav.LibMaster.models.*;
import java.util.*;

public interface BookRepository extends MongoRepository<Book, UUID>{ }