package com.example.postgresql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgresqlApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {

        return args -> {
            studentRepository.deleteAll();

            Student maria = new Student(
                    "Maria",
                    "Jones",
                    "maria.jones@amigoscode.edu",
                    21
            );
            Student ahmed = new Student(
                    "Maria",
                    "Ali",
                    "ahmed.ali@amigoscode.edu",
                    21
            );
//            studentRepository.save(maria);
            System.out.println("Adding maria and ahmed");
            studentRepository.saveAll(List.of(maria, ahmed));

            studentRepository.findStudentByEmail("ahmed.ali@amigoscode.edu")
                    .ifPresentOrElse(System.out::println,
                            ()-> System.out.println("Student with email ahmed.ali@amigoscode.edu not found"));

            studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEqualNative("Maria",21)
                    .forEach(System.out::println);

//
            System.out.println(studentRepository.deleteStudentById(22L));
        };

    }

}
