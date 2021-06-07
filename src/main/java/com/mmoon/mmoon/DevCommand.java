package com.mmoon.mmoon;

import jdk.jfr.Enabled;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DevCommand implements CommandExecutor {

    private MMoon plugin;
    private boolean enabled;


    public DevCommand(MMoon plugin) { this.plugin = plugin;   }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if(!sender.hasPermission("mmoon.dev")){
            sender.sendMessage(ChatColor.RED + "You dont have permission.");
            return true;
        }

        if(args.length == 0){
            return false;
        }
        if(Boolean.parseBoolean(args[0]) == true){
            enabled = true;
            sender.sendMessage("Developer mode" + ChatColor.GREEN + " on");
        }
        if(Boolean.parseBoolean(args[0]) == false){
            enabled = false;
            sender.sendMessage("Developer mode" + ChatColor.RED + " off");
        }
        return true;
    }
}
