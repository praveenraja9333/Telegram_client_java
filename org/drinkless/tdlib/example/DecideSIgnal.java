package org.drinkless.tdlib.example;


import org.drinkless.tdlib.TdApi;
import vrp.product.telegram.copier.Copier;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecideSIgnal {
    String fileNameGerManyDown ="C:\\Users\\Praveen\\AppData\\Roaming\\MetaQuotes\\Terminal\\Common\\Files\\Signals\\ger40\\Down";
    String fileNameGerManyUp  ="C:\\Users\\Praveen\\AppData\\Roaming\\MetaQuotes\\Terminal\\Common\\Files\\Signals\\ger40\\Up";
    String fileNameUs100Down ="C:\\Users\\Praveen\\AppData\\Roaming\\MetaQuotes\\Terminal\\Common\\Files\\Signals\\us100\\Down";
    String fileNameUs100Up  ="C:\\Users\\Praveen\\AppData\\Roaming\\MetaQuotes\\Terminal\\Common\\Files\\Signals\\us100\\Up";
    String germanyStop  ="C:\\Users\\Praveen\\AppData\\Roaming\\MetaQuotes\\Terminal\\Common\\Files\\Signals\\ger40\\stop";
    String us100Stop  ="C:\\Users\\Praveen\\AppData\\Roaming\\MetaQuotes\\Terminal\\Common\\Files\\Signals\\us100\\stop";
    Pattern germanyUp= Pattern.compile("text = \"[Dd][Ee].*[Uu][Pp]\"");
    Pattern germanyDown= Pattern.compile("text = \"[Dd][Ee].*[Dd][Oo][Ww][Nn]\"");
    Pattern germanyUp1= Pattern.compile("text = \"[Uu][Pp].*[Dd][Ee]\"");
    Pattern germanyDown1= Pattern.compile("text = \"[Dd][Oo][Ww][Nn].*[Dd][Ee]\"");
    Pattern nas100Down1= Pattern.compile("text = \"100.*[Dd][Oo][Ww][Nn]\"");
    Pattern nas100Down2= Pattern.compile("text = \"[Dd][Oo][Ww][Nn].*100\"");
    Pattern nas100Up1= Pattern.compile("text = \"100.*[Uu][Pp]\"");
    Pattern nas100Up2= Pattern.compile("text = \"[Uu][Pp].*100\"");
    Pattern start= Pattern.compile("text = \"[Ss][Tt][Aa][Rr][Tt]\"");
    Pattern deStart= Pattern.compile("text = \"[Dd][Ee].*[Ss][Tt][Aa][Rr][Tt]\"");
    Pattern us100Start= Pattern.compile("text = \"[Uu][Ss].*[Ss][Tt][Aa][Rr][Tt]\"");
    Pattern stop= Pattern.compile("text = \"[Ss][Tt][Oo][Pp]\"");
    Pattern deStop= Pattern.compile("text = \"[Dd][Ee].*[Ss][Tt][Oo][Pp]\"");
    Pattern us100stop= Pattern.compile("text = \"[Uu][Ss].*[Ss][Tt][Oo][Pp]\"");
    Pattern regexGroup=Pattern.compile("(.*)(\".*\")(.*)");
    Map<Long,Long>   chatIdToMessageId= new HashMap<>();
    long messageId=0;
    long adminMessageId=0;
    boolean isDeStarted=true;
    boolean isUs100Started=true;
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
        if(germanyUp.matcher(value).find() && isDeStarted){
            File germany=new File(fileNameGerManyUp);
            if(germany.exists()){
                 germany.delete();
            }
            germany.createNewFile();
            File germany1=new File(fileNameGerManyUp+"1");
            if(germany1.exists()){
                germany1.delete();
            }
            germany1.createNewFile();
            sendValue(chat.lastMessage.chatId,value);
        }else if(germanyDown.matcher(value).find() && isDeStarted){
            File germany=new File(fileNameGerManyDown);
            if(germany.exists()){
                germany.delete();
            }
            germany.createNewFile();
            File germany1=new File(fileNameGerManyDown+"1");
            if(germany1.exists()){
                germany1.delete();
            }
            germany1.createNewFile();
            sendValue(chat.lastMessage.chatId,value);
        }
        else if(germanyUp1.matcher(value).find() && isDeStarted){
            File germany=new File(fileNameGerManyUp);
            if(germany.exists()){
                germany.delete();
            }
            germany.createNewFile();
            File germany1=new File(fileNameGerManyUp+"1");
            if(germany1.exists()){
                germany1.delete();
            }
            germany1.createNewFile();
            sendValue(chat.lastMessage.chatId,value);
        }
        else if(germanyDown1.matcher(value).find() && isDeStarted){
            File germany=new File(fileNameGerManyDown);
            if(germany.exists()){
                germany.delete();
            }
            germany.createNewFile();
            File germany1=new File(fileNameGerManyDown+"1");
            if(germany1.exists()){
                germany1.delete();
            }
            germany1.createNewFile();
            sendValue(chat.lastMessage.chatId,value);
        }

        //US
        if(nas100Up1.matcher(value).find() && isUs100Started){
            File us=new File(fileNameUs100Up);
            if(us.exists()){
                us.delete();
            }
            us.createNewFile();
            File us1=new File(fileNameUs100Up+"1");
            if(us1.exists()){
                us1.delete();
            }
            us1.createNewFile();
            sendValue(chat.lastMessage.chatId,value);
        }else if(nas100Down1.matcher(value).find() && isUs100Started){
            File us=new File(fileNameUs100Down);
            if(us.exists()){
                us.delete();
            }
            us.createNewFile();
            File us1=new File(fileNameUs100Down+"1");
            if(us1.exists()){
                us1.delete();
            }
            us1.createNewFile();
            sendValue(chat.lastMessage.chatId,value);
        }
        else if(nas100Up2.matcher(value).find() && isUs100Started){
            File us=new File(fileNameUs100Up);
            if(us.exists()){
                us.delete();
            }
            us.createNewFile();
            File us1=new File(fileNameUs100Up+"1");
            if(us1.exists()){
                us1.delete();
            }
            us1.createNewFile();
            sendValue(chat.lastMessage.chatId,value);
        }
        else if(nas100Down2.matcher(value).find() && isUs100Started){
            File us=new File(fileNameUs100Down);
            if(us.exists()){
                us.delete();
            }
            us.createNewFile();
            File us1=new File(fileNameUs100Down+"1");
            if(us1.exists()){
                us1.delete();
            }
            us1.createNewFile();
            sendValue(chat.lastMessage.chatId,value);
        }

    }

    public boolean processHalt(TdApi.Chat chat) throws IOException {
        if(adminMessageId == chat.lastMessage.id||adminMessageId==0){
            System.out.println("No new Message"+this.adminMessageId);
            this.adminMessageId=chat.lastMessage.id;
            return false;
        }
        this.adminMessageId = chat.lastMessage.id;
        //TdApi.MessageContent content=  chat.lastMessage.content;
        String value= chat.lastMessage.content.toString();
        System.out.println("new Message For Admin "+value);
        if(deStop.matcher(value).find()){
            File germany=new File(germanyStop);
            File germany1=new File(germanyStop+"1");
            if(germany.exists()){
                germany.delete();
            }
            if(germany1.exists()){
                germany1.delete();
            }
            germany.createNewFile();
            germany1.createNewFile();
            isDeStarted=false;
            Example.setCheckForPublish(true);
            return true;
        }else if(us100stop.matcher(value).find()){
            File us100=new File(us100Stop);
            File us100_1=new File(us100Stop+"1");
            if(us100.exists()){
                us100.delete();
            }
            if(us100_1.exists()){
                us100_1.delete();
            }
            us100.createNewFile();
            us100_1.createNewFile();
            isUs100Started=false;
            Example.setCheckForPublish(true);
            return true;
        }else if(deStart.matcher(value).find()){
            isDeStarted=true;
            return true;
        }else if(us100Start.matcher(value).find()){
            isUs100Started=true;
            return true;
        }else if(stop.matcher(value).find()){
            File germany=new File(germanyStop);
            File germany1=new File(germanyStop+"1");
            if(germany.exists()){
                germany.delete();
            }
            if(germany1.exists()){
                germany.delete();
            }
            germany.createNewFile();
            germany1.createNewFile();
            File us100=new File(us100Stop);
            File us100_1=new File(us100Stop+"1");
            if(us100.exists()){
                us100.delete();
            }
            if(us100_1.exists()){
                us100.delete();
            }
            us100.createNewFile();
            us100_1.createNewFile();
            Example.setCheckForPublish(true);
            isDeStarted=false;
            isUs100Started=false;
            return true;
        }else if(start.matcher(value).find()){
            isDeStarted=true;
            isUs100Started=true;
            return true;
        }
        return false;
    }

    public void processSingalsForCopier(TdApi.Chat chat){
        long messageIdSender=chatIdToMessageId.getOrDefault(chat.lastMessage.chatId,0L);
        if(messageIdSender == chat.lastMessage.id||messageIdSender==0){
            System.out.println("No new Message"+messageIdSender);
            chatIdToMessageId.put(chat.lastMessage.chatId,chat.lastMessage.id);
            return;
        }
        chatIdToMessageId.put(chat.lastMessage.chatId,chat.lastMessage.id);
        //TdApi.MessageContent content=  chat.lastMessage.content;
        String value= chat.lastMessage.content.toString();
        value=value.replace("\n", "");
        System.out.println("channelCopier in Action"+value);
        if(germanyUp.matcher(value).find()||germanyDown.matcher(value).find()||germanyUp1.matcher(value).find()||germanyDown1.matcher(value).find()||nas100Up1.matcher(value).find()||nas100Down1.matcher(value).find()||nas100Up2.matcher(value).find()||nas100Down2.matcher(value).find()){
            sendValue(chat.lastMessage.chatId,value);
        }
    }

    public void sendValue(Long chatId,String value){
        value=value.replace("\n", "");
        Matcher matcher= regexGroup.matcher(value);
        if(matcher.matches())
            Copier.publishToAll(chatId,matcher.group(2).replace("\"",""));
    }



    public static void main(String[] args) throws IOException {
        DecideSIgnal signal=new DecideSIgnal();
     //   signal.processSignal("text = \"DE UP\"");
    }
}



