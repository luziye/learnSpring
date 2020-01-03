package com.luziye.bootluanch.jpa.testdb2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true, length = 32)
    private String name;

    @Column(nullable = false, length = 512)
    private String content;

}
