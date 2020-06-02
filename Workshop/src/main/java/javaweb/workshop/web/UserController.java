package javaweb.workshop.web;

import javaweb.workshop.domain.binding.LoginUserBinding;
import javaweb.workshop.domain.binding.RegisterUserBinding;
import javaweb.workshop.domain.servicemodel.LoginUserServiceModel;
import javaweb.workshop.domain.servicemodel.SetUserServiceModel;
import javaweb.workshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;
    @Autowired
    public UserController(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(ModelAndView modelAndView) {

        modelAndView.setViewName("/register");

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(ModelAndView modelAndView) {

        modelAndView.setViewName("/login");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid @ModelAttribute("registerUser")
                                     RegisterUserBinding registerUserBinding,
                                     BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/register");
        } else {
            if (!registerUserBinding.getPassword().equals(registerUserBinding.getConfirmPassword())) {
                modelAndView.setViewName("/register");
            } else {
                SetUserServiceModel setUserServiceModel = this.mapper.map(registerUserBinding, SetUserServiceModel.class);

                if (this.userService.userExists(setUserServiceModel)) {

                    modelAndView.setViewName("/register");

                } else {

                    this.userService.seedUser(setUserServiceModel);
                    modelAndView.setViewName("/home");

                }

            }
        }

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@Valid @ModelAttribute("loginUserAttribute")
                                              LoginUserBinding loginUserBinding,
                                  BindingResult bindingResult, ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {

            modelAndView.setViewName("/login");

        } else {
            LoginUserServiceModel loginUserServiceModel = this.mapper.map(loginUserBinding, LoginUserServiceModel.class);
            if (this.userService.userExists(loginUserServiceModel)) {

                modelAndView.setViewName("/home");

            } else {

                modelAndView.setViewName("/login");

            }

        }

        return modelAndView;
    }

}