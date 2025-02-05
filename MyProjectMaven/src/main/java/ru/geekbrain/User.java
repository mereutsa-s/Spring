package ru.geekbrain;

import com.vaadin.flow.component.template.Id;

import javax.persistence.*;
import java.util.Set;
//public class User {
//    private String name;
//    private int age;
//    private String email;
//
//    public User(String name, int age, String email) {
//        this.name = name;
//        this.age = age;
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    @Override
//    public String toString() {
//        return "User{name='" + name + "', age=" + age + ", email='" + email + "'}";
//    }
//}


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User(String name, int age, String email) {
    }

    // Геттеры и сеттеры
}

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Геттеры и сеттеры
}