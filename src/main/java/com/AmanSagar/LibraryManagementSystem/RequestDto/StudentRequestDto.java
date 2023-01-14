package com.AmanSagar.LibraryManagementSystem.RequestDto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentRequestDto {
    private String name;
    @Column(unique = true)
    private String email;
}
