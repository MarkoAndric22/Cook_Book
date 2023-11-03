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
public class Ingridient {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  @NotNull(message = "Name must be included.")
  @Size(min=2,max = 30, message= "Name must be beetwen {min} and {max} characters long.")
  private String name;

  @Column
  @NotNull(message ="unit of measure must be included")
  private  Integer unitOfMeasure;

  @Column
  @NotNull(message ="number of calories must be included")
  private Integer numberCaloria;

  @Column
  @NotNull(message ="carbohydrates must be included")
  private Integer carbohydrates;

  @Column
  @NotNull(message ="fats must be included")
  private  Integer fats;

  @Column
  @NotNull(message ="proteins must be included")
  private  Integer proteins;


  @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
  @JoinTable(
    name = "ingredient_allergen",
    joinColumns = @JoinColumn(name = "ingredient_id"),
    inverseJoinColumns = @JoinColumn(name = "allergen_id")

  )
  private List<Allergen> allergens;

  @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
  List<Recipe> recipes;
}
