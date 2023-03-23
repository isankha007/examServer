package com.exam.entity.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quiz")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qId;
    private String title;
    private String description;


//    private Long cid;
    private boolean active;
    private int numberOfQuestion;

    private int maxMarks;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade =CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private Set<Question> questionSet=new HashSet<>();
}
