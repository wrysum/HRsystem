package com.example.HRsystem.entity;

import com.example.HRsystem.enums.Category;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private byte[] image;
    private String nameCompany;
    private String title;
    private String description;
    @ManyToOne
    private Category category;
    private String email;
    LocalDateTime dateTime;
    private String[] phoneNumber = new String[4] ;
    private int salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;
    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }
}