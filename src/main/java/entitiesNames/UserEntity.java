package entitiesNames;

import utils.EmailGenerator;

import static utils.EmailGenerator.generateRandomEmail;

public enum UserEntity {
    NAME("newusername"),
    LASTNAME("newusersurname"),
    EMAIL(EmailGenerator.generateRandomEmail()),
    PASSWORD("UserPassword1!"),
    REPEAT_PASSWORD("UserPassword1!");

    private final String fieldName;

    UserEntity(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
