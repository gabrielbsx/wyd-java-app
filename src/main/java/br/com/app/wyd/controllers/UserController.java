package br.com.app.wyd.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.wyd.models.User;

@RestController
@RequestMapping("/users")
public class UserController {
  private List<User> users = new ArrayList<>();
  
  @GetMapping("/{id}")
  public User findOne(@PathVariable Long id) {
    Optional<User> userFound = users.stream().filter(u -> u.getId().equals(id)).findFirst();
    if (userFound.isPresent()) {
      return userFound.get();
    }
    return null;
  }

  @PostMapping({ "/", "" })
  public User create(@RequestBody User user) {
    users.add(user);
    return user;
  }

  @GetMapping("/all")
  public List<User> findAll() {
    return users;
  }
}
