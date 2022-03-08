package com.example.hellospring;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RestController
public class HelloController {
    public static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index() {
        String nameOS = "os.name";  
      String versionOS = "os.version";  
      String architectureOS = "os.arch";
      System.out.println("\n  The information about OS");
      System.out.println("\nName of the OS: " + System.getProperty(nameOS));
      System.out.println("Version of the OS: " + System.getProperty(versionOS));
      System.out.println("Architecture of THe OS: " + System.getProperty(architectureOS));  
       return "Greetings from Azure Spring Cloud!";
    }
    
    @RequestMapping("/ls")
    public String ls(){
        String s;
        Process p;
        String outputx="Logs:" ;
        outputx +=System.lineSeparator();
        try {
            p = Runtime.getRuntime().exec("ps -aux");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null){
                outputx += s;
                outputx +=System.lineSeparator();
            }
            p.waitFor();
            System.out.println(outputx);
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {
            outputx += "ERROR";
        }
        return outputx;
    }

}
