package recommend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import recommend.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
	
	//@Query(value = "ALTER TABLE user AUTO_INCREMENT = 1;", nativeQuery = true)
	//void resetAutoInc();

	User findUserBySong(String song);
}