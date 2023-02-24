package es.iesjandula.jgp.mongodb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.jgp.mongodb.model.User;
import es.iesjandula.jgp.mongodb.repository.IUserRepository;

@Service
public class UserService
{
	@Autowired
	private IUserRepository userRepository;

	public void consultas()
	{
		System.out.println("Todos los usuarios");
		for (User user : this.userRepository.findAll())
		{
			System.out.println(user.toString());
		}
		System.out.println();
		
		System.out.println("Usuarios por nombre");
		for (User user : this.userRepository.findByFirstName("Gary"))
		{
			System.out.println(user.toString());
		}
		System.out.println();
		
		System.out.println("Usuarios VIP");
		for (User user : this.userRepository.findByVipTrue())
		{
			System.out.println(user.toString());
		}
		System.out.println();
		
		System.out.println("Usuarios By Name @Query");
		for (User user : this.userRepository.findByName("Gary"))
		{
			System.out.println(user.toString());
		}
		System.out.println();
		
//		System.out.println("Apellidos By Name @Query");
//		for (String user : this.userRepository.findLastNameByFirstName("Gary"))
//		{
//			System.out.println(user.toString());
//		}
//		System.out.println();
	}
}
