package com.example.todoapp;

import com.example.postgresql.Student;
import com.example.postgresql.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class PostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgresqlApplication.class, args);
    }

    private Student makeAStudent() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
        Student student = new Student(
                firstName,
                lastName,
                email,
                faker.number().numberBetween(17, 55));
        return student;
    }

    private ToDoList makeAToDoList() {
        Faker faker = new Faker();
        String name = faker.name().name();
        ToDoList list = new ToDoList(name, LocalDateTime.now());
        return list;
    }

    @Bean
    CommandLineRunner commandLineRunner(ToDoListRepo toDoListRepo) {

        return args -> {

            ToDoList list = makeAToDoList();
            toDoListRepo.save(list);
//
//            StudentIdCard studentIdCard = new StudentIdCard("543219876", student);
//
//            student.addBook(
//                    new Book(LocalDateTime.now().minusDays(4), "Clean Code")
//            );
//            student.addBook(
//                    new Book(LocalDateTime.now(), "Think and Grow Rich")
//            );
//            student.addBook(
//                    new Book(LocalDateTime.now().minusYears(1), "Spring Data JPA")
//            );

//            student.addEnrolment(new Enrolment(
//                    new EnrolmentId(1L,1L),
//                    student,
//                    new Course("CS","IT"),
//                    LocalDateTime.now()
//            ));
//            student.addEnrolment(new Enrolment(
//                    new EnrolmentId(1L,2L),
//                    student,
//                    new Course("CS2","IT"),
//                    LocalDateTime.now()
//            ));


//            studentIdCardRepository.save(studentIdCard);

//            student.setStudentIdCard(studentIdCard);
//            studentRepository.save(student);

//            student.enrolToCourse(new Course("CS", "IT"));
//            student.enrolToCourse(new Course("Spring Data JPA course", "IT"));

//            studentRepository.save(student);

//            studentRepository.findById(24L).ifPresent(
//                    s -> {
//                        List<Book> books = student.getBooks();
//                        books.forEach(book -> {
//                            System.out.println(s.getFirstName() + " borrowed " + book.getBookName());
//                        });
//                    });

//            studentIdCardRepository.findById(1L).ifPresent(System.out::println);
        };

    }



//    private void sorting(StudentRepository studentRepository) {
//        //            Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
//        Sort sort = Sort.by( "firstName").ascending().and(Sort.by("age").descending());
//        studentRepository.findAll(sort)
//                .forEach(student -> System.out.println(student.getFirstName()
//                        + " " + student.getAge()));
//    }

    private void generateRandomStudents(StudentRepository studentRepository) {
        Faker faker = new Faker();

        for (int i = 0; i <= 10; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);

            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));
            studentRepository.save(student);
        }
    }

}
