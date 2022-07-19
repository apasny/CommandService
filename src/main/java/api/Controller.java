package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import entity.User;
import mapper.EntityMapper;
import repository.UsersRepositoryImpl;

@RestController
public class Controller {

	@Autowired
	private UsersRepositoryImpl usersRepositoryImpl;

	@Autowired
	private EntityMapper entityMapper;

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> users = usersRepositoryImpl.getAll();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@PostMapping("/users")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveUser(@RequestBody String user) {

		User userEntity = entityMapper.mapToEntity(user);

		usersRepositoryImpl.create(userEntity);
	}

	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) {
		usersRepositoryImpl.delete(id);
	}
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		
		User user = usersRepositoryImpl.getUserById(id);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
