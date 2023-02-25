package es.iesjandula.jgp.mongodb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import es.iesjandula.jgp.mongodb.model.User;
import es.iesjandula.jgp.mongodb.repository.IUserRepository;

@Service
public class UserService
{
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	MongoOperations mongoOperations;

	public void consultas()
	{
		System.out.println("All Users");
		for (User user : this.userRepository.findAll())
		{
			System.out.println(user.toString());
		}
		System.out.println();

		System.out.println("Users By Name");
		for (User user : this.userRepository.findByFirstName("Gary"))
		{
			System.out.println(user.toString());
		}
		System.out.println();

		System.out.println("V.I.P Users");
		for (User user : this.userRepository.findByVipTrue())
		{
			System.out.println(user.toString());
		}
		System.out.println();

		System.out.println("Users By Last Name Order By Age Desc");
		for (User user : this.userRepository.findByName("Fuller"))
		{
			System.out.println(user.toString());
		}
		System.out.println();

		System.out.println("Last Name By Name");
		for (String user : this.userRepository.findLastNameByFirstName("Gary"))
		{
			System.out.println(user.toString());
		}
		System.out.println();

		System.out.println("V.I.P Users By Name");
		for (User user : this.userRepository.findVipByName("Gary"))
		{
			System.out.println(user.toString());
		}
		System.out.println();

		System.out.println("Find by Name or Last Name");
		for (User user : this.userRepository.findByNameOrLastName("Fuller"))
		{
			System.out.println(user.toString());
		}
		System.out.println();

		System.out.println("Find Users Greater Equal That The Passed Age");
		for (User user : this.userRepository.findByAgeGreaterEqualThat(20))
		{
			System.out.println(user.toString());
		}
		System.out.println();

		System.out.println("User with 18 year: " + this.userRepository.countUserWith18Years());
		System.out.println();

		System.out.println("User with greater age");
		PageRequest pageRequest = PageRequest.of(0, 1);
		for (User user : this.userRepository.findByUserWithGreaterAge("", pageRequest))
		{
			System.out.println(user.toString());
		}
		System.out.println();

		// Query that filter the users and show the user with lower age
		List<User> find = this.mongoOperations.find(Query.query(Criteria.where("firstName").regex("", "i"))
				.with(Sort.by(Sort.Direction.ASC, "age")).limit(1), User.class);

		System.out.println("User with lower age");
		for (User user : find)
		{
			System.out.println(user.toString());
		}
		System.out.println();
	}
}
