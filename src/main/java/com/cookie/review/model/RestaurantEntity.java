package com.cookie.review.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter //private로 선언해서
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Restaurant")
@Entity
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private ZonedDateTime createdAt;
    private ZonedDateTime updateAt;

    public void changeNameAndAddress(String name, String address){
        this.name = name;
        this.address = address;
        this.updateAt = ZonedDateTime.now();

    }

}
