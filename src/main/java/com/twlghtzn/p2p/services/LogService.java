package com.twlghtzn.p2p.services;

import com.twlghtzn.p2p.models.LogEntry;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

  @Autowired
  public LogService() {
  }

  public String renderLogEntryForDisplay(LogEntry logEntry) {
    String log = getTimeStamp(logEntry.getDate()) + " " +
        logEntry.getLevel() + " " +
        logEntry.getText() + " " +
        logEntry.getEndpoint() + " " +
        logEntry.getRequestType() + " " +
        logEntry.getRequestParams();
    return log;
  }

  public String getTimeStamp(LocalDateTime date) {
    String ldt = String.valueOf(date);
    return ldt.replace('T', ' ');
  }
}