package com.example.postgresql;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
        }
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "age",
            nullable = false

    )
    private Integer age;


    @OneToOne( // relationship to studentIdCard
            mappedBy = "student", // bidirectional relationship
            orphanRemoval = true, // 也就是說，把學生移除時，學生卡會被自動移除。但是學生卡被移除時，學生不會被移除 (若設為false 刪學生時，學生卡就不會自動被刪)
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private StudentIdCard studentIdCard;

    @OneToMany ( // one student to many books (前者One是主體)
        mappedBy = "student",
            orphanRemoval = true, // when remove a student, also remove books associate with the student
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, // student add book 就會直接寫進book table
            // The cascade persist is used to specify that if an entity is persisted then all its associated child entities will also be persisted.
            // CascadeType. REMOVE : It means that the related entities are deleted when the owning entity is deleted.
            // CascadeType. DETACH. The detach operation removes the entity from the persistent context.
            // When we use CascadeType. DETACH, the child entity will also get removed from the persistent context.
            fetch = FetchType.EAGER // 要注意使用這個的效能，所以default 用lazy，真的需要才改為Eager
    )
    private List<Book> books = new ArrayList<>();



    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "student"
    )
    private List<Enrolment> enrolments = new ArrayList<>();

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void addEnrolment(Enrolment enrolment) {
        if (!enrolments.contains(enrolment)) {
            enrolments.add(enrolment);
        }
    }

    public void removeEnrolment(Enrolment enrolment) {
        enrolments.remove(enrolment);
    }


    public void addBook(Book book) {
        if (!this.books.contains(book)) {
            this.books.add(book);
            book.setStudent(this); // bi-directional
        }
    }
    public void removeBook(Book book){
        if(this.books.contains(book)){
            this.books.remove(book);
            book.setStudent(null);
        }
    }

    public void setStudentIdCard(StudentIdCard studentIdCard){
        this.studentIdCard = studentIdCard;
    }

    public List<Book> getBooks(){
        return books;
    }

    public Student(
//            Long id,
                   String firstName,
                   String lastName,
                   String email,
                   Integer age) {
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}