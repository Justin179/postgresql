package com.example.todoapp;

import com.example.postgresql.Student;
import com.example.postgresql.StudentRepository;
import com.example.todoapp.model.ToDoItem;
import com.example.todoapp.model.ToDoList;
import com.example.todoapp.model.ToDoUser;
import com.example.todoapp.repo.ToDoItemRepo;
import com.example.todoapp.repo.ToDoListRepo;
import com.example.todoapp.repo.ToDoUserRepo;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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

    private ToDoUser makeAUser() {
        Faker faker = new Faker();
        String username = faker.name().username();
        ToDoUser user = new ToDoUser(username);
        return user;
    }

    private ToDoItem makeAItem() {
        Faker faker = new Faker();
        String name = faker.name().name();
        String description = faker.commerce().productName();
        ToDoItem item = new ToDoItem(name, description, LocalDateTime.now());
        return item;
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(
            ToDoUserRepo toDoUserRepo,
            ToDoListRepo toDoListRepo,
            ToDoItemRepo toDoItemRepo) {

        return args -> {

            /*
            // 新增一個清單(內含三項目)
            ToDoList list = makeAToDoList();
            for (int i = 0; i<3; i++){
                list.addItem(makeAItem()); // 在一個清單中，加入三個項目
            }
            toDoListRepo.save(list);

            // 查詢清單及其項目
            toDoListRepo.findById(2l).ifPresent(toDoList -> {
                System.out.println("fetch list wz items: " + toDoList);
                List<ToDoItem> items = toDoList.getItems();
                items.forEach(toDoItem -> {
                    System.out.println(toDoList.getName() + " -> " + toDoItem.getName());
                });
            });

            // 修改
            toDoListRepo.findById(2l).ifPresent(toDoList -> {
                Faker faker = new Faker();
                String name = faker.name().name();
                toDoList.setName(name);
                List<ToDoItem> items = toDoList.getItems();
                items.forEach(toDoItem -> {
                    String item_name = faker.name().name();
                    toDoItem.setName(item_name);
                    toDoItemRepo.save(toDoItem);
                });
//                for (ToDoItem item : items){
//                    item.setName(faker.name().name());
//                    toDoItemRepo.save(item);
//                }
                toDoListRepo.save(toDoList); // save
            });

            // 刪除
            toDoListRepo.findById(2l).ifPresent(toDoListRepo::delete);
            */


            // 新增1使用者 新增2清單(內含三項目)
//            ToDoUser user = makeAUser();
//            ToDoList list = makeAToDoList();
//            ToDoList list2 = makeAToDoList();
//            for (int i = 0; i<3; i++){
//                list.addItem(makeAItem()); // 在一個清單中，加入三個項目
//                list2.addItem(makeAItem()); // 在一個清單中，加入三個項目
//            }
//            user.addUserListMapper(new UserListMapper(
//                    new UserListMapperId(),
//                    user,
//                    list
//            ));
//            user.addUserListMapper(new UserListMapper(
//                    new UserListMapperId(),
//                    user,
//                    list2
//            ));
//            toDoUserRepo.save(user);

            // 查出某個使用者 手上的清單
//            List<ToDoList> lists = toDoListRepo.findListByUserIdNative(6L);
//            for (ToDoList list : lists){
//                System.out.println(list.getId());
//            }


            // 查詢清單及其項目
//            toDoListRepo.findById(2l).ifPresent(toDoList -> {
//                System.out.println("fetch list wz items: " + toDoList);
//                List<ToDoItem> items = toDoList.getItems();
//                items.forEach(toDoItem -> {
//                    System.out.println(toDoList.getName() + " -> " + toDoItem.getName());
//                });
//            });


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
