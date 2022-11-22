package vttp.day22.day22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.day22.day22.models.Task;
import vttp.day22.day22.models.User;
import vttp.day22.day22.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public boolean createUser(final User user) throws Exception {
        int count= userRepo.createUser(user);
        System.out.printf("Insert count: %d\n", count);
        return count>0; 
       }

    
    public boolean createTask(final User user, final Task task) throws Exception {

        int count= userRepo.createTask(user, task);
        System.out.printf("Insert count %d\n", count);
        return count >0;
    }
    
}
