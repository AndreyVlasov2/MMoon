package com.mmoon.mmoon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    private MMoon plugin;

    public Command(MMoon plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(!sender.hasPermission("mmoon.info")){
            sender.sendMessage(ChatColor.RED + "You dont have permission.");
            return true;
        }

        if(args.length == 0){
            return false;
        }

        String name = args[0];
        Player p = Bukkit.getPlayer(name);
        if(p == null){
            sender.sendMessage(name + " is not online");
            return true;
        }

        sender.sendMessage("IP: " + p.getAddress().getAddress());

        return true;
    }
}
