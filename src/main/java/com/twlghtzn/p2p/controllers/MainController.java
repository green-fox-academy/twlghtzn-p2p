package com.twlghtzn.p2p.controllers;

import com.twlghtzn.p2p.models.LogEntry;
import com.twlghtzn.p2p.services.LogService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  private LogService logService;

  @Autowired
  public MainController(LogService logService) {
    this.logService = logService;
  }

  @GetMapping("/")
  public String showMainPage() {
    System.out.println(logService.renderLogEntryForDisplay(new LogEntry(LocalDateTime.now(), "INFO", "Request", "/", "GET", " ")));
    return "index";
  }
}
