package com.example.redisapi.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {

    private String id;
    private String name;
    private String email;
    private String phone;


}
