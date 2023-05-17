package com.muhammet.randomUserMe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Root{
    public String gender;
    public Name name;
   // public Location location;
    public String email;
//    public Login login;
//   public Dob dob;
 //   public Registered registered;
    public String phone;
    public String cell;
  // public Id id;
 //   public Picture picture;
    public String nat;
}
