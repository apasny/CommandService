package repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public interface UsersRepository {
	
	boolean create(User user);
	User getUserById(Long chatId);
	boolean update(Long userId);
	boolean delete(Long userId);
	List<User> getAll();
	
}
