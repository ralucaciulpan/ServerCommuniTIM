package rr.ServerCommuniTIM.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rr.ServerCommuniTIM.model.User;
import rr.ServerCommuniTIM.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User registerUser(User user){
        if(user.getUsername() != null && user.getPassword() != null){
            return userRepository.save(user);
        }
        else
        {
            User errorUser = new User("Error Name","Error password","Error muie");
            return userRepository.save(errorUser);
        }
    }

    public User loginUser(String username, String password) {
        User response = userRepository.findByUsernameAndPassword(username,password).orElse(null);
        if(response!=null){
            System.out.println("This is the response: " + response);
            return response;

        }
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username does not exist.\n");
    }

}
