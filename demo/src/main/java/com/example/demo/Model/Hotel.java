package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Name")
    private String name;
    @Column(name="Address")
    private String address;
    @Column(name="City")
    private String city;
    @Column(name="Country")
    private String country;
    @Column(name="Star rating")
    private int starRating;
}
