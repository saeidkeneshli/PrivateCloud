package org.j2os.classFinal.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "car")
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car implements Serializable
{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "NUMBER")
    private Long carId;

    @Column(columnDefinition = "VARCHAR2(20)")
    private String model;

    @Column(columnDefinition = "NUMBER")
    private Long ownerId;
}
