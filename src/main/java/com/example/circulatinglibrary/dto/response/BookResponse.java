package com.example.circulatinglibrary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookResponse {
    private int id;
    private String names;
    private String author;
    private int counts;
}
