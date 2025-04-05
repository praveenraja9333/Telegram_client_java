package vrp.product.telegram.copier;

import org.drinkless.tdlib.example.Example;

import java.util.*;
import java.util.stream.Collectors;

public class Copier {

    private static HashSet<Long> senders;
    private static HashSet<String> customers;
    private static HashSet<Long> processedSenders=new HashSet<>();
    private static HashMap<Long, Set<Long>> SendersCustomerMapping=new HashMap<>();

    static {
               senders=new HashSet<>();
               senders.add(1570707914L);
               customers=new HashSet<>();
               customers.add("1570707914:777000");
               for(String s: customers){
                   String[] splits=s.split(":");
                   Set<Long> sh=SendersCustomerMapping.getOrDefault(Example.getChatId(splits[0]),new HashSet<>());
                   sh.add(Example.getChatId(splits[1]));
                   SendersCustomerMapping.put(Example.getChatId(splits[0]),sh);
               }
    }

    public static boolean isSender(Long sender){
              return senders.contains(sender);
    }



    public static void publishToAll(Long sender,String value) {
               if (!processedSenders.contains(sender)&&senders.contains(sender)&&Example.isIsCopierEnabled()) {
                   Set<Long> recepients = SendersCustomerMapping.get(sender);
                   if(Objects.nonNull(recepients)){
                          for(Long receipent : recepients){
                              Example.sendMessage(receipent,value);
                          }
                   }
                   processedSenders.add(sender);
                }
    }

    public static Set<Long> getSenders(){
        return senders;
    }

    public static void clearProcessedSenders(){
        processedSenders.clear();
    }


}
