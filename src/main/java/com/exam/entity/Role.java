package com.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
@Setter
@Getter
public class Role {

    @Id
    private Long roleId;
    private String roleName;
}
