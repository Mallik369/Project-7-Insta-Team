package com.teamtreehouse.project.web;

/**
 * Created by Mallikarjuna on 12/17/2016.
 */
public class FlashMessage {
  private String message;
  private Status status;

  public FlashMessage(String message, Status status) {
    this.message = message;
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public Status getStatus() {
    return status;
  }

  public enum Status {
    SUCCESS,FAILURE
  }
}
