package marumasa.auto_message;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AllSendMessage extends BukkitRunnable {

    private List<String> MessageData;
    private List<String> MessageRemove = new ArrayList<>();

    public AllSendMessage(Config data) {
        MessageData = data.Messages;
    }

    @Override
    public void run() {
        if (MessageData.isEmpty()) {
            MessageData = MessageRemove;
            MessageRemove = new ArrayList<>();
        }
        final int RANDOM = new Random().nextInt(MessageData.size());
        final String Message = MessageData.get(RANDOM);
        MessageRemove.add(Message);
        MessageData.remove(RANDOM);
        Bukkit.broadcastMessage(Message);
    }
}