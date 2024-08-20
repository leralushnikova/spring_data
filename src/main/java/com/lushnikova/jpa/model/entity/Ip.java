package com.lushnikova.jpa.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "ips")
@SequenceGenerator(name = "ips_id_generator", sequenceName = "ips_id_seq", allocationSize = 1)
public class Ip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ips_id_generator")
    private Long id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "time")
    private LocalDate date;
}