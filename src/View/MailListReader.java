package View;

import Model.Mail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    public static List<Mail> read(String fileName){
        List<Mail> mailList = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while(true){
                String line = reader.readLine();
                if(line == null)
                    break;
                if(Mail.isMail(line))
                    mailList.add(new Mail(line));
            }
        } catch(FileNotFoundException exception){
            System.out.println("ERROR: MailListReader::read(FileNotFoundException)");
        } catch(IOException exception){
            System.out.println("ERROR: MailListReader::read(IOException)");
        }
        return mailList;
    }
}
