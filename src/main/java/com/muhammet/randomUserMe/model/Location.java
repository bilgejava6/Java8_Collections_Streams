package com.muhammet.randomUserMe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Location{
    public Street street;
    public String city;
    public String state;
    public String country;
    public Integer postcode;
    public Coordinates coordinates;
    public Timezone timezone;
}
