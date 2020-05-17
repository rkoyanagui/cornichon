package br.com.rkoyanagui.cornichon.utils;

public class ReportingException extends RuntimeException {

  private static final long serialVersionUID = 1405506826837913282L;

  public ReportingException(String message) {
    super(message);
  }

  public ReportingException(String message, Throwable cause) {
    super(message, cause);
  }

  public ReportingException(Throwable cause) {
    super(cause);
  }
}
