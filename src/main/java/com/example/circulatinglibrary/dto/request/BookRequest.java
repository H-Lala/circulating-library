package com.example.circulatinglibrary.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private int id;
    private String names;
    private String author;
    private int counts;
}
