package com.twlghtzn.p2p.services;

import com.twlghtzn.p2p.models.LogEntry;
import com.twlghtzn.p2p.models.MessageRequest;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

  @Autowired
  public LogService() {
  }

  public String renderLogEntryForDisplay(LogEntry logEntry) {
    return getTimeStamp(logEntry.getDate()) + " " +
        logEntry.getLevel() + " " +
        logEntry.getText() + " " +
        logEntry.getEndpoint() + " " +
        logEntry.getRequestType() + " " +
        logEntry.getRequestParams();
  }

  public String getTimeStamp(LocalDateTime date) {
    String ldt = String.valueOf(date);
    return ldt.replace('T', ' ');
  }

  public String buildLogForMain(String requestParams) {
    return renderLogEntryForDisplay(new LogEntry(LocalDateTime.now(),
        "INFO", "Request", "/", "GET", requestParams));
  }

  public String buildLogForRegisterGet(String requestParams) {
    return renderLogEntryForDisplay(new LogEntry(LocalDateTime.now(),
        "INFO", "Request", "/register", "GET", requestParams));
  }

  public String buildLogForRegisterPost(String requestParams) {
    return renderLogEntryForDisplay(new LogEntry(LocalDateTime.now(),
        "INFO", "Request", "/register", "POST", requestParams));
  }

  public String buildLogForUpdate(String requestParams) {
    return renderLogEntryForDisplay(new LogEntry(LocalDateTime.now(),
        "INFO", "Request", "/update", "POST", requestParams));
  }

  public String buildLogForMainPost(String requestParams) {
    return renderLogEntryForDisplay(new LogEntry(LocalDateTime.now(),
        "INFO", "Request", "/", "POST", requestParams));
  }

  public String buildLogForReceive(MessageRequest messageRequest) {
    return renderLogEntryForDisplay(new LogEntry(LocalDateTime.now(),
        "INFO", "Request", "/api/message/receive", "POST", renderParams(messageRequest)));
  }

  public String renderParams(MessageRequest messageRequest) {
    return "message: id=" + messageRequest.getMessage().getRandomId() + ", username=" +
        messageRequest.getMessage().getUserName() + ", text=" +
        messageRequest.getMessage().getText() + ", timestamp=" +
        messageRequest.getMessage().getDate() + ", client: id=" +
        messageRequest.getClient().getUniqueId();
  }
}
