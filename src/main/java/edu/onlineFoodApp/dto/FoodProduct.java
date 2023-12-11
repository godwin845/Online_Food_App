package edu.onlineFoodApp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FoodProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 255, nullable = false)
    private String name;

    private double totalPrice;
    private double discount;
    private int availability;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(length = 3000)
    private String description;

}
