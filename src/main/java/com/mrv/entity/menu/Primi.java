package com.mrv.entity.menu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "primi")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Primi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private BigDecimal price;

    @Column(unique = true)
    private String name;

    private String Description;
}
