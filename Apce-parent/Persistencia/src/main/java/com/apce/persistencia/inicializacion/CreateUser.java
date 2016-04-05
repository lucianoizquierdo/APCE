package com.apce.persistencia.inicializacion;

public class CreateUser {  
    //Spring will populate these fields through Dependency Injection.  
        private String name;  
    private String email;  
    private String URL;  
  
    public CreateUser(){}  
    public String getName() {  
      return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getEmail() {  
        return email;  
    }  
  
    public void setEmail(String email) {  
        this.email = email;  
    }  
  
    public String getURL() {  
        return URL;  
    }  
  
    public void setURL(String url) {  
        URL = url;  
    }  
    public void displayUser() {  
        System.out.println("Name=" + this.name);  
       
    }  
}  