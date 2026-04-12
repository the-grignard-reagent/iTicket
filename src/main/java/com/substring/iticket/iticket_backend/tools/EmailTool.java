package com.substring.iticket.iticket_backend.tools;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class EmailTool {

    @Tool(description = "This tool helps to send email to support team regarding new tickets")
    public void sendEmailToSupportTeam(@ToolParam(description = "Email id associated with ticket for contacting") String email,
                                       @ToolParam(description = "Short description of the issue") String message){
            System.out.println("Sending email to team of support");
            System.out.println(("email id :" + email));
            System.out.println("message :" +  message);
    }
}
