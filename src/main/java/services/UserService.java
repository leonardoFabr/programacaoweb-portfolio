package services;

import org.springframework.stereotype.Service;
import entities.User;
import java.util.List;

@Service
public interface UserService {
	List<User> findAll();
    User findById(Integer id);
    User insert(User user);
    void delete(Integer id);
    User update(Integer id, User updatedUser);
}
