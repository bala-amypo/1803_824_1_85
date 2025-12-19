ackage com.example.demo.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Property;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;

@Service
public class UserServiceimpls implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public Property register(User user) {
        return repo.save(user);
    }

    @Override
    public List<Property> findByemail() {
        return repo.findAll();
    }
}