package com.devbrunorafael.springsecuritylogin.domain.model;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String username;

    @Setter(AccessLevel.NONE)
    private String password;

    private String name;
    @Column(name = "last_name")
    private String lastName;

    private boolean enable;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;


    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder()
                .encode(password);
    }
}
