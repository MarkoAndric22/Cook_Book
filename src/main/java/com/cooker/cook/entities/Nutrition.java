package com.cooker.cook.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Nutrition {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

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

  @OneToOne
  private Ingridient ingridient;
}
