package com.cooker.cook.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Cooker extends User{


  @ManyToMany
  @JoinTable(name = "cooker_recipe",
    joinColumns = @JoinColumn(name = "cooker"),
    inverseJoinColumns = @JoinColumn(name = "recipe")
  )
    private List<Recipe> recipes;

}
