package es.iesjandula.jgp.mongodb.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.iesjandula.jgp.mongodb.model.Json;
import es.iesjandula.jgp.mongodb.model.User;
import es.iesjandula.jgp.mongodb.repository.IUserRepository;

@Service
public class ParseoUserImpl
{
	// list of users
	private List<User> userList;

	// repository of users
	@Autowired
	private IUserRepository userRepository;

	public final void readJson()
	{
		try
		{
			// create a ObjectMapper used the mapper of class JSON
			ObjectMapper mapper = Json.mapper();

			// Convert a JSON to list of users
			this.userList = mapper.readValue(Paths
					.get("src" + File.separator + "main" + File.separator + "resources" + File.separator + "user.json")
					.toFile(), new TypeReference<List<User>>()
					{
					});

			// save the list of user in the database
			this.userRepository.saveAll(this.userList);
		}
		catch (StreamReadException streamReadException)
		{
			streamReadException.printStackTrace();
		}
		catch (DatabindException databindException)
		{
			databindException.printStackTrace();
		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
		}
	}
}
