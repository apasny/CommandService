package mapper;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.User;

@Component
public class EntityMapper {

	public String mapToJson(User user) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(user);

		return json;
	}

	public User mapToEntity(String userJson) {

		Gson gson = new Gson();
		User trackingReportEntity = gson.fromJson(userJson, User.class);

		return trackingReportEntity;
	}

}
