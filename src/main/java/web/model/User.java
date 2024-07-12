package web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "bigint")
    private long id;

    @Column(name = "firstname", columnDefinition = "varchar(32)")
    @NotEmpty(message = "Firstname shouldn't be empty")
    @Size(min = 2, max = 30, message = "Firstname should be between 2 and 30 chars")
    private String firstName;

    @Column(name = "lastname", columnDefinition = "varchar(32)")
    @NotEmpty(message = "Lastname shouldn't be empty")
    @Size(min = 2, max = 30, message = "Lastname should be between 2 and 30 chars")
    private String lastName;

    @Column(name = "birthday", columnDefinition = "date")
    @PastOrPresent(message = "Birthday should be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "email", columnDefinition = "varchar(32)")
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Name shouldn't be empty")
    private String email;

    @Column(name = "phone_number", columnDefinition = "varchar(32)")
    @NotEmpty(message = "Phone number shouldn't be empty")
    @Size(min = 2, max = 30, message = "Phone number should be between 5 and 32 chars")
    @Pattern(regexp = "^(\\+)?(\\d{1,4})?[\\s-]?\\(?\\d{1,4}\\)?[\\s.-]?\\d{1,4}[\\s.-]?\\d{1,4}[\\s.-]?\\d{1,4}$",
            message = "Incorrect phone format")
    private String phoneNumber;

    public User() {
    }

    public User(String firstName, String lastName, LocalDate birthday, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
