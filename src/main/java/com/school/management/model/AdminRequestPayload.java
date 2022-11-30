package com.school.management.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminRequestPayload {

   private String userName;
   private String passWord;
   private String firstName;
   
   private String lastName;
}
