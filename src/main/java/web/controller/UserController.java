package web.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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


    @GetMapping
    public String printUsers(ModelMap model) {
        model.addAttribute("userList", userService.getUsers());
        return "users_list";
    }


    @GetMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "user_create";
    }

    @PostMapping(value ="/create")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_create";
        }

        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping(value ="/delete")
    public String deleteUser(@ModelAttribute("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/update")
    public String updateForm(@ModelAttribute("id") Long id, Model model) {
        User userById = userService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", userById);
        return "user_update";
    }

    @PostMapping(value ="/update")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_update";
        }

        userService.updateUser(user);
        return "redirect:/users";
    }
}
