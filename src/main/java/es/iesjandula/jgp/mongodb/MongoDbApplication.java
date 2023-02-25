package es.iesjandula.jgp.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.iesjandula.jgp.mongodb.impl.ParseoUserImpl;
import es.iesjandula.jgp.mongodb.impl.UserService;

@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private ParseoUserImpl parseoUser;
	
	public static void main(String[] args)
	{
		SpringApplication.run(MongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		this.parseoUser.readJson();
		this.userService.consultas();
	}
}
