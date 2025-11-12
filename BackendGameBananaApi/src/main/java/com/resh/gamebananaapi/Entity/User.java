package com.resh.gamebananaapi.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private String username;
    private int totalScore;


    // Constructors for cohesion
    public User() {}
    public User(String username) { this.username = username; this.totalScore = 0; }


    // Encapsulated getters and setters
    public String getId() { return id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public int getTotalScore() { return totalScore; }
    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }
}
