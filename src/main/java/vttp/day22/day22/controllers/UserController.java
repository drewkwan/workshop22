package vttp.day22.day22.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import vttp.day22.day22.models.Task;
import vttp.day22.day22.models.User;
import vttp.day22.day22.repositories.UserRepository;
import vttp.day22.day22.service.UserService;

@Controller
// @RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userSvc;

    @Autowired
    private UserRepository userRepo;

    @PostMapping(path="/user")
    public String postUser(@RequestBody MultiValueMap<String, String> form, Model model) {

        String username = form.getFirst("username");
        String password = form.getFirst("password");
        String email = form.getFirst("email");
        String phone = form.getFirst("phone");
        String dob = form.getFirst("dob");

        System.out.printf("username: %s, password: %s, email: %s, phone: %s, dob: %s\n"
                            , username, password, email, phone, dob);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setDob(dob);

        try {
            if (!userSvc.createUser(user)){
                System.out.println(">>>>>> error! user not created :(");            
            };
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "error";
        }


        model.addAttribute("username", username);
        return "created";

    }

    @GetMapping("/task")
    public String getTask(Model model) {
        return "task";
    }
    
    @PostMapping("/task")
        public String postTask(@RequestBody MultiValueMap<String, String> form, Model model) {
            
            String username = form.getFirst("username");
            String password = form.getFirst("password");
            String taskName = form.getFirst("taskName");
            String priority = form.getFirst("priority");
            String assignTo = form.getFirst("username");
            String completionDate = form.getFirst("completionDate");

            System.out.printf("username: %s, password: %s, task name: %s, priority: %s, completion date: %s\n"
                            , username, password, taskName, priority, completionDate);

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            Task task = new Task();
            task.setTaskName(taskName);
            task.setAssignTo(assignTo);
            task.setPriority(priority);
            task.setCompletionDate(completionDate);
            
            try {
                if (userRepo.verifyUser(username, password) == 0) {
                    System.out.println(">>>>>> error! failed authentication! :(");
                    model.addAttribute("errorMsg", "failed authentication!");
                    return "error";
                    } else {
                    userSvc.createTask(user, task);
                    System.out.println("Task created successfully!");
                    model.addAttribute("taskName", taskName);
                    model.addAttribute("assignTo", assignTo);
                    return "taskCreated";
                    }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("errorMsg", e.getMessage());
                return "error";
            }
        }
}
