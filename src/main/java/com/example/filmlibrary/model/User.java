package com.example.filmlibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@SequenceGenerator(
        name = "default_generator",
        sequenceName = "user_seq",
        allocationSize = 1
)
@NoArgsConstructor
public class User extends GenericModel {

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "created_when")
    private LocalDateTime createdWhen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",
            nullable = false, foreignKey = @ForeignKey(name = "FK_USER_ROLES"))
    private Role role;
}
