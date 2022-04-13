package com.emtech.drp.workflow_user_login.script;

import java.util.ArrayList;
import java.util.List;

class Department {

  private String name;
  private String tabColor;
  private List<User> users = new ArrayList<>();

  public Department() {
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(final List<User> users) {
    this.users = users;
  }

  public String getTabColor() {
    return tabColor;
  }

  public void setTabColor(String tabColor) {
    this.tabColor = tabColor;
  }
}
