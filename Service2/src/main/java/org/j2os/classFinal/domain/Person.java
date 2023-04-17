package org.j2os.classFinal.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "person")
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person implements Serializable
{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR2(20)")
    private String name;

    @Column(columnDefinition = "VARCHAR2(20)")
    private String family;

    @Column(columnDefinition = "NUMBER")
    private Long carId;
}
