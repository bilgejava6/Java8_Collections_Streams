package com.muhammet.randomUserMe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Info {

        private String seed;
        private Integer results;
        private Integer page;
        private String version;
//     "seed": "e9b31952ea98f487",
//             "results": 5,
//             "page": 1,
//             "version": "1.4"
//
}
