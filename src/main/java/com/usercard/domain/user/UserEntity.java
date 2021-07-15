package com.usercard.domain.user;

import lombok.Data;

import javax.persistence.*;

@Table(name = "tb_user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_seq")
    private Long id;
    private String phoneNumber;
    private String name;
}
