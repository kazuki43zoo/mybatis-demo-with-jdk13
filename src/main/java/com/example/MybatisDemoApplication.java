package com.example;

import com.example.domain.Todo;
import com.example.mapper.TodoMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class MybatisDemoApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(MybatisDemoApplication.class, args);
  }

  private final TodoMapper todoMapper;

  public MybatisDemoApplication(TodoMapper todoMapper) {
    this.todoMapper = todoMapper;
  }

  @Transactional
  @Override
  public void run(String... args) {
    Todo newTodo = new Todo();
    newTodo.setTitle("飲み会");
    newTodo.setDetails("銀座 19:00");

    todoMapper.insert(newTodo);

    Todo loadedTodo = todoMapper.select(newTodo.getId());
    System.out.println("ID       : " + loadedTodo.getId());
    System.out.println("TITLE    : " + loadedTodo.getTitle());
    System.out.println("DETAILS  : " + loadedTodo.getDetails());
    System.out.println("FINISHED : " + loadedTodo.isFinished());
  }

}
