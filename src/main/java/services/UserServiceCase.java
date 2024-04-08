package services;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceCase implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public User update(Integer id, User updatedUser) {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                user.setNome(updatedUser.getNome());
                user.setEmail(updatedUser.getEmail());
                user.setTelefone(updatedUser.getTelefone());
                user.setPassword(updatedUser.getPassword());
                return userRepository.save(user);
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        return null;
    }
}