package com.example.postgresql;

import javax.annotation.PreDestroy;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "StudentIdCard")
@Table(
        name = "student_id_card",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_id_card_number_unique",
                        columnNames = "card_number"
                )
        }
)
public class StudentIdCard {



    @Id
    @SequenceGenerator(
            name = "student_card_id_sequence",
            sequenceName = "student_card_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_card_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "card_number",
            nullable = false,
            length = 15
    )
    private String cardNumber;

    @OneToOne( // relationship to student
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER // 1 to 1 relationship is default which means when loading the student id card, also load the student
                                    // on the other hand, lazy don't load the student
    )
    @JoinColumn(
            name = "student_id", // student_id_card.(FK)student_id
            referencedColumnName = "id", // student.(PK)id
            foreignKey = @ForeignKey(
                    name = "student_id_fk"
            )
    )
    private Student student; // save the card, also save the student

    public StudentIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public StudentIdCard() {
    }

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }

}