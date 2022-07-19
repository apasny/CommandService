package entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "users", schema = "command")
@Component
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId")
	@SequenceGenerator(name = "userId", sequenceName = "command.users_id_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "chat_id")
	private Long chatId;

	@Column(name = "role")
	private String role;

	public User() {
	}

	public User(String userName, Long chatId, String role) {
		this.userName = userName;
		this.chatId = chatId;
		this.role = role;
	}

	public User(Long id, String userName, Long chatId, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.chatId = chatId;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chatId, id, role, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(chatId, other.chatId) && Objects.equals(id, other.id) && Objects.equals(role, other.role)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", chatId=" + chatId + ", role=" + role + "]";
	}

}
