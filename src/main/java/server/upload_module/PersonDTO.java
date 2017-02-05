package server.upload_module;

import java.io.Serializable;

public class PersonDTO implements Serializable {
    public PersonDTO(String name, String birthDay, String email) {
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
    }

    private String name;
    private String birthDay;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
