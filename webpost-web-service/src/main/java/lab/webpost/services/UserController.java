package lab.webpost.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lab.webpost.domain.Post;
import lab.webpost.domain.User;

@RestController
public class UserController {
    @Autowired
  private  UserRepository userRepository;


    //TODO: end point for validate user by username 
    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
      Optional<User> optUser = userRepository.findByUsername(username);

        if(optUser.isPresent()){
return new ResponseEntity<>(optUser.get(),HttpStatus.OK);
        }else{
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
