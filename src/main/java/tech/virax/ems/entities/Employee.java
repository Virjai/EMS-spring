package tech.virax.ems.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(name = "e_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "e_name", length = 50, nullable = false)
    private String name;

    @Column(name = "e_age", nullable = false)
    private int age;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "e_salary", nullable = false)
    private double salary;

    @Column(name = "e_designation", nullable = false)
    private String designation;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

}
