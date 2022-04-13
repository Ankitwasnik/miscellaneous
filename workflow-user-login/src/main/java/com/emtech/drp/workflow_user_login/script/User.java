package com.emtech.drp.workflow_user_login.script;

class User {

  private String role;
  private String email;
  private String password;

  public User() {
  }

  public User(final String email, final String password, final String role) {
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public String getRole() {
    return role;
  }

  public void setRole(final String role) {
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }
}
