package com.example.circulatinglibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "books",schema = "public")
public class Books {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "names")
    String names;
    @Column(name = "author")
    String author;
    @Column(name = "counts")
    int counts;


}
