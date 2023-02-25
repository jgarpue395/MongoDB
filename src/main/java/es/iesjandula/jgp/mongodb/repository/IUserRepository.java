package es.iesjandula.jgp.mongodb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import es.iesjandula.jgp.mongodb.model.User;

public interface IUserRepository extends MongoRepository<User, Long>
{
	// filter user by name
	List<User> findByFirstName(String firstName);

	// show the V.I.P users
	List<User> findByVipTrue();

	// filter user by last name sort by age descendant
	@Query(value = "{'lastName': ?0}", sort = "{age : -1}")
	List<User> findByName(String lastName);

	// show the last name of the users whose name is the indicated name
	@Query(value = "{'firstName': ?0}", fields = "{'lastName' : 1, 'id' : 0}")
	List<String> findLastNameByFirstName(String firstName);

	// show the users whose name is the indicated name and are V.I.P
	@Query("{'firstName': ?0, 'vip' : true}")
	List<User> findVipByName(String firstName);

	// show the users whose name or last name is the passed by parameters
	@Query("{$or: [{'firstName': ?0}, {'lastName' : ?0}]}")
	List<User> findByNameOrLastName(String name);

	// show the user greater or equal that the passed age
	@Query("{'age': {$gte: ?0}}")
	List<User> findByAgeGreaterEqualThat(int age);

	// count the users with 18 years
	@Query(value = "{'age': 18}", count = true)
	Long countUserWith18Years();

	// show the user with greater age
	@Query(value = "{'firstName': {$regex: ?0, $options: 'i'}}", sort = "{age: -1}", count = true)
	List<User> findByUserWithGreaterAge(String name, Pageable pageable);
}
