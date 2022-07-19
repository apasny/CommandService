package repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.User;

@Component
public class UsersRepositoryImpl implements UsersRepository {

	@Autowired
	DatabaseConnector databaseConnector;

	@Override
	public boolean create(User user) {

		Session session = databaseConnector.startTransaction();

		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		return true;
	}

	@Override
	public User getUserById(Long chatId) {
		
		Session session = databaseConnector.startTransaction();

		return (User) session.createQuery("from User U where U.chatId = :chatId", User.class).setParameter("chatId", chatId).getSingleResult();
	}

	@Override
	public boolean update(Long trackingReportId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long userId) {
		Session session = databaseConnector.startTransaction();

		int rows = session.createQuery("DELETE FROM User U WHERE U.id = :id").setParameter("id", userId)
				.executeUpdate();

		return rows > 0;
	}

	@Override
	public List<User> getAll() {

		Session session = databaseConnector.startTransaction();

		return session.createQuery("from User", User.class).getResultList();
	}

}
