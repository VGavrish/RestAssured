package factories;

import entities.User;
import entitiesNames.UserEntity;

public class UserFactory {
    public static User createUser() {
        return new User(UserEntity.NAME.getFieldName(),
                UserEntity.LASTNAME.getFieldName(),
                UserEntity.EMAIL.getFieldName(),
                UserEntity.PASSWORD.getFieldName(),
                UserEntity.REPEAT_PASSWORD.getFieldName());
    }

}
