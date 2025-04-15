package web.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persons")
public class User {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 to 30")
    private String name;
    @Column(name = "age")
    private int age;
    @Email(message = "Email should be valid")
    @Column(name = "mail")
    private String email;

    public User() {

    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Name should not be empty") @Size(min = 2, max = 30, message = "Name should be between 2 to 30") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Name should not be empty") @Size(min = 2, max = 30, message = "Name should be between 2 to 30") String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User [id = %d; name = %s; age = %s; email = %s]",
                id, name, age, email);
    }
}
