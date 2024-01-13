package ca.sheridancollege.crud.Beans;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "avengers")
public class Avenger {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String name;
    int age;

}
