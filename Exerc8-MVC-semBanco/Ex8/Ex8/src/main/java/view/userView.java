package view;

import controller.userController;
import model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class userView {
    userController usercontroller = new userController();

    @GetMapping
    public List<User> getAll(){
        return usercontroller.getAll();
    }

    @GetMapping("/{id}")
    public User getByid(@PathVariable Long id){
        return  usercontroller.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody User user){
        return usercontroller.insert(user);
    }

    @PutMapping("/{id}")
    public User update (@RequestBody User user, @PathVariable Long id){
        return usercontroller.update(id, user);

    }

}
