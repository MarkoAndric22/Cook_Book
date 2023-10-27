package com.cooker.cook.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "User_Type")
public abstract class  User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable=false)
  @NotNull(message="First name must be provided")
  @Size(min=2,max=30, message= "First name must be beetwen {min} and {max} characters long.")
  private String FirstName;

  @Column(nullable=false)
  @NotNull(message="Last name must be provided")
  @Size(min=2,max=30, message= "Last name must be beetwen {min} and {max} characters long.")
  private String LastName;

  @Column(nullable=false, unique = true)
  @NotNull(message="username must be provided")
  @Size(min=5,max=20, message= "username must be beetwen {min} and {max} characters long.")
  private String username;

  @Column(nullable=false,name="password")
  @NotNull(message="Password must be provided")
  @Size(min=6,max=30, message= "password must be beetwen {min} and {max} characters long.")
  @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{6,30}$", message = "Password must be at least 6 characters long and contain a lowercase, an upercase letter and a number")
  private String password;



}
