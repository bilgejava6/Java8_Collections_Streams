package com.muhammet.ornek;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Calisan {
    String ad;
    String adres;
    String telefon;
    Bolum bolum;
}
