package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.model.enums.Category;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "licenses")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int serialNumber;
    @Enumerated(EnumType.STRING)
    Category category;

    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    Person person;

    public License(int serialNumber, Category category) {
        this.serialNumber = serialNumber;
        this.category = category;
    }
}
