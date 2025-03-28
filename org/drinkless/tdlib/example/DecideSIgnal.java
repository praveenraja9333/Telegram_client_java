package org.drinkless.tdlib.example;


import org.drinkless.tdlib.TdApi;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecideSIgnal {
    String fileNameGerManyDown ="C:\\Users\\Praveen\\AppData\\Roaming\\MetaQuotes\\Terminal\\Common\\Files\\Signals\\ger40\\Down";
    String fileNameGerManyUp  ="C:\\Users\\Praveen\\AppData\\Roaming\\MetaQuotes\\Terminal\\Common\\Files\\Signals\\ger40\\Up";
    String fileNameUs100Down ="C:\\Users\\Praveen\\AppData\\Roaming\\MetaQuotes\\Terminal\\Common\\Files\\Signals\\us100\\Down";
    String fileNameUs100Up  ="C:\\Users\\Praveen\\AppData\\Roaming\\MetaQuotes\\Terminal\\Common\\Files\\Signals\\us100\\Up";
    Pattern germanyUp= Pattern.compile("text = \"[Dd][Ee].*[Uu][Pp]\"");
    Pattern germanyDown= Pattern.compile("text = \"[Dd][Ee].*[Dd][Oo][Ww][Nn]\"");
    Pattern germanyUp1= Pattern.compile("text = \"[Uu][Pp].*[Dd][Ee]\"");
    Pattern germanyDown1= Pattern.compile("text = \"[Dd][Oo][Ww][Nn].*[Dd][Ee]\"");
    Pattern nas100Down1= Pattern.compile("text = \"100.*[Dd][Oo][Ww][Nn]\"");
    Pattern nas100Down2= Pattern.compile("text = \"[Dd][Oo][Ww][Nn].*100\"");
    Pattern nas100Up1= Pattern.compile("text = \"100.*[Uu][Pp]\"");
    Pattern nas100Up2= Pattern.compile("text = \"[Uu][Pp].*100\"");
    long messageId=0;
    public void processSignal(TdApi.Chat chat) throws IOException {
        if(messageId == chat.lastMessage.id||messageId==0){
            System.out.println("No new Message"+this.messageId);
            this.messageId=chat.lastMessage.id;
            return;
        }
        this.messageId = chat.lastMessage.id;
        //TdApi.MessageContent content=  chat.lastMessage.content;
        String value= chat.lastMessage.content.toString();
        System.out.println("new Message "+value);
        if(germanyUp.matcher(value).find()){
            File germany=new File(fileNameGerManyUp);
            if(germany.exists()){
                 germany.delete();
            }
            germany.createNewFile();
        }else if(germanyDown.matcher(value).find()){
            File germany=new File(fileNameGerManyDown);
            if(germany.exists()){
                germany.delete();
            }
            germany.createNewFile();
        }
        else if(germanyUp1.matcher(value).find()){
            File germany=new File(fileNameGerManyUp);
            if(germany.exists()){
                germany.delete();
            }
            germany.createNewFile();
        }
        else if(germanyDown1.matcher(value).find()){
            File germany=new File(fileNameGerManyDown);
            if(germany.exists()){
                germany.delete();
            }
            germany.createNewFile();
        }

        //US
        if(nas100Up1.matcher(value).find()){
            File us=new File(fileNameUs100Up);
            if(us.exists()){
                us.delete();
            }
            us.createNewFile();
        }else if(nas100Down1.matcher(value).find()){
            File us=new File(fileNameUs100Down);
            if(us.exists()){
                us.delete();
            }
            us.createNewFile();
        }
        else if(nas100Up2.matcher(value).find()){
            File us=new File(fileNameUs100Up);
            if(us.exists()){
                us.delete();
            }
            us.createNewFile();
        }
        else if(nas100Down2.matcher(value).find()){
            File us=new File(fileNameUs100Down);
            if(us.exists()){
                us.delete();
            }
            us.createNewFile();
        }

    }

    public static void main(String[] args) throws IOException {
        DecideSIgnal signal=new DecideSIgnal();
     //   signal.processSignal("text = \"DE UP\"");
    }
}



