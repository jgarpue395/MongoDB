package es.iesjandula.jgp.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import es.iesjandula.jgp.mongodb.model.User;

public interface IUserRepository extends MongoRepository<User, String>
{
	List<User> findByFirstName(String firstName);
	List<User> findByVipTrue();
	
	@Query("{'firstName' : ?0}")
	List<User> findByName(String firstName);
	
//	@Query(value = "{'firstName' : ?0}, fields = {lastName: 1, id: 0}")
//	List<String> findLastNameByFirstName(String firstName);
}
