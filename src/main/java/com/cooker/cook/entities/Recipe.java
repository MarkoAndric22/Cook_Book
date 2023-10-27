package com.cooker.cook.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  @NotNull(message = "Name must be included.")
  @Size(min=2,max = 30, message= "Name must be beetwen {min} and {max} characters long.")
  private String name;

  @Column
  @NotNull(message = "description must be included.")
  private String description;

  @Column
  @NotNull(message = "steps for prepare must be included.")
  private String stepsForPrepare;

  @Column
  @NotNull(message = "time for prepare must be included.")
  private Integer timeForPrepare;

  @Column
  @NotNull(message = "quantity must be included.")
  private  Integer quantity;

  @ManyToMany
  private List<Cooker> cookers;

  @ManyToMany
  private List<RegularUser> regularUsers;

  @ManyToMany
  @JoinTable(name = "recipe_ingredient",
    joinColumns = @JoinColumn(name = "recipe"),
    inverseJoinColumns = @JoinColumn(name = "ingridient")
  )
  private List<Ingridient> ingridients;


}
