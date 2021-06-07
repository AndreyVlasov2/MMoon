package com.mmoon.mmoon;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Handler implements Listener {

    private MMoon plugin;

    public Handler(MMoon plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void join(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.DARK_RED + "MineMoon!");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) { Player p = e.getPlayer();
        if (p.getWorld().getBlockAt(p.getLocation().add(0, -1, 0)).getType().equals(Material.NETHERRACK)) {
            p.setFireTicks(99999);
        } else {
            p.setFireTicks(0);
        }
    }

    @EventHandler
    public void onPlayerInteractEntity (PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        Player p = event.getPlayer();
        if(plugin.isEnabled()) {
            if ((entity instanceof Player) && (p.hasPermission("mmoon.kickPlayer"))) {
                Player otherPlayer = (Player) entity;
                otherPlayer.kickPlayer(new String((ChatColor.DARK_RED + "You were kicked from the server.").getBytes(UTF_8), UTF_8));
            }
        }

        }
}








