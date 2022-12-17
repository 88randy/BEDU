package org.bedu.JMS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    
    private String subject;
    private String to;
    private String from;
    private String body;
}
