package com.exam.entity.exam;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "question")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questId;
    private String answer;

    @Column(length = 5000)
    private String content;

    private String image;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @ManyToOne
    private Quiz quiz;


}
