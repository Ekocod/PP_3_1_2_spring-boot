package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/new")
    public String getUserFormForCreate(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String saveCreatedUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String getUserFormForUpdate(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user) {
        userService.updateUser(user, id);
        return "redirect:/users";
    }
}