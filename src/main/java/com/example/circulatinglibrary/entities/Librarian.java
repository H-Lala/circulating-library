package com.example.circulatinglibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "librarian",schema = "public")
public class Librarian {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
}
