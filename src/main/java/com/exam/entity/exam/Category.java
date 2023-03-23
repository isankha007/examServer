package com.exam.entity.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;
    private String title;
    private String description;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quiz> quizSet=new LinkedHashSet<>();
}
