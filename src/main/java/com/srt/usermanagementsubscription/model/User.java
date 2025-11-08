package com.srt.usermanagementsubscription.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
   private long id;
   private String name;
   private String address;
   private String planName;
   private LocalDate Subscription = LocalDate.now();
}
