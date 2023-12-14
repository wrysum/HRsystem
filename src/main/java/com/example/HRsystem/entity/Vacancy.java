package com.example.HRsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte[] image;
    private String nameCompany;
    private String title;
    private String description;
    @ManyToOne
    private Category category;
    private String email;
    LocalDateTime dateTime;
    private String[] phoneNumber = new String[4];
    private Integer salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;
    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }
}