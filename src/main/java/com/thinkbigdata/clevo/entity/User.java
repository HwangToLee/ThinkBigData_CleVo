package com.thinkbigdata.clevo.entity;

import com.thinkbigdata.clevo.role.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @NoArgsConstructor
public class User {
    @Id @Column(name = "User_id") @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "User_email", nullable = false, unique = true)
    private String email;
    @Column(name = "User_password", nullable = false)
    private String password;
    @Column(name = "User_name", nullable = false)
    private String name;
    @Column(name = "User_nickname")
    private String nickname;
    @Enumerated(value = EnumType.STRING) @Column(name = "User_role", nullable = false)
    private Role role;
    @Column(name = "User_age", nullable = false)
    private Integer age;
    @Column(name = "User_gender", nullable = false)
    private String gender;
    @Column(name = "User_level")
    private Integer level;
    @Column(name = "User_target")
    private Integer target;
    @Column(name = "User_date") @CreatedDate @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    @Column(name = "User_last_login")
    private LocalDateTime last;

    @Builder
    public User(String email, String name, String nickname, Integer age, String gender, Integer level, Integer target) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.level = level;
        this.target = target;
        this.role = Role.USER;
    }
}