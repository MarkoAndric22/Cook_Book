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
public class RegularUser extends User{


  @ManyToMany
  @JoinTable(name = "regularUser_recipe",
    joinColumns = @JoinColumn(name = "user"),
    inverseJoinColumns = @JoinColumn(name = "recipe")
  )
    private List<Recipe> recipes;

  @ManyToMany
  @JoinTable(name = "regularUser_allergen",
    joinColumns = @JoinColumn(name = "regularUser"),
    inverseJoinColumns = @JoinColumn(name = "allergen")
  )
  private List<Allergen> allergens;
}
