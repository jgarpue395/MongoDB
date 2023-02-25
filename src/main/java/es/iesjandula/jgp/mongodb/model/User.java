package es.iesjandula.jgp.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesús García Puerto
 *
 */
@Document(collection = "user")
public class User
{
	@Id
	private Long id;
	
	@Field(name = "first_name")
	@JsonProperty(value = "first_name")
	private String firstName;
	
	@Field(name = "last_name")
	@JsonProperty(value = "last_name")
	private String lastName;
	
	private int age;
	
	private String email;
	
	private String country;
	
	private String modified;
	
	private boolean vip;

	//getters and setters
	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public int getAge()
	{
		return this.age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCountry()
	{
		return this.country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getModified()
	{
		return this.modified;
	}

	public void setModified(String modified)
	{
		this.modified = modified;
	}

	public boolean isVip()
	{
		return this.vip;
	}

	public void setVip(boolean vip)
	{
		this.vip = vip;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email="
				+ email + ", country=" + country + ", modified=" + modified + ", vip=" + vip + "]";
	}
}
