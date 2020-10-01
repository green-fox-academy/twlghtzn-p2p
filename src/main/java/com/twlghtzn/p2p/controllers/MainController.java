package com.twlghtzn.p2p.controllers;

import com.twlghtzn.p2p.services.LogService;
import com.twlghtzn.p2p.services.MessageService;
import com.twlghtzn.p2p.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
  private LogService logService;
  private UserService userService;
  private MessageService messageService;

  @Autowired
  public MainController(LogService logService, UserService userService,
                        MessageService messageService) {
    this.logService = logService;
    this.userService = userService;
    this.messageService = messageService;
  }

  @GetMapping("/")
  public String showMainPage(Model model) {
    if (model.getAttribute("user") == null) {
      if (userService.isUserPresent()) {
        System.out.println(logService.buildLogForMain("info=emptyInput"));
        model.addAttribute("info", "emptyInput");
        model.addAttribute("name", userService.getUsersName());
      } else {
        System.out.println(logService.buildLogForMain(""));
      }
    } else {
      String userName = (String) model.getAttribute("user");
      System.out.println(logService.buildLogForMain("user=" + userName));
      model.addAttribute("name", userName);
      model.addAttribute("messages", messageService.getAllMessages());
    }
    return "index";
  }

  @PostMapping("/")
  public String addAMessage(RedirectAttributes attributes,
                            @RequestParam(name = "text") String text) {
    System.out.println(logService.buildLogForMainPost("text=" + text));
    messageService.addNewUserMessage(text);
    attributes.addFlashAttribute("user", userService.getUsersName());
    return "redirect:/";
  }

  @GetMapping("/register")
  public String showRegisterPage(Model model) {
    if (model.getAttribute("info") == null) {
      System.out.println(logService.buildLogForRegisterGet(""));
    } else if (model.getAttribute("info") == "emptyInput") {
      System.out.println(logService.buildLogForRegisterGet("info=emptyInput"));
      model.addAttribute("info", "emptyInput");
    }
    return "register";
  }

  @PostMapping("/register")
  public String registerUser(RedirectAttributes attributes,
                             @RequestParam(name = "userName", required = false) String userName) {
    if (userName.equals("")) {
      System.out.println(logService.buildLogForRegisterPost(""));
      attributes.addFlashAttribute("info", "emptyInput");
      return "redirect:/register";
    } else if (!userService.isUserPresent()) {
      System.out.println(logService.buildLogForRegisterPost("userName=" + userName));
      userService.addUser(userName);
      attributes.addFlashAttribute("user", userName);
    }
    return "redirect:/";
  }

  @PostMapping("/update")
  public String updateUser(RedirectAttributes attributes,
                           @RequestParam(name = "name", required = false) String name) {
    if (name.isEmpty()) {
      System.out.println(logService.buildLogForUpdate(""));
      attributes.addFlashAttribute("info", "emptyInput");
    } else if (userService.isUserPresent()) {
      System.out.println(logService.buildLogForUpdate("user=" + name));
      userService.updateUser(name);
      attributes.addFlashAttribute("user", name);
    }
    return "redirect:/";
  }
}


