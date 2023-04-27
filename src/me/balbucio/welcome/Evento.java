package me.balbucio.welcome;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Evento implements Listener{
	
	@EventHandler
	public void OnlineToggle(PostLoginEvent e) {
		if(!Main.getInstance().usarserver) {
			for(String s : Main.getInstance().list_string) {
		      e.getPlayer().sendMessage(new TextComponent(s));
			}
		} else {
			Main.getInstance().users.add(e.getPlayer().getName());
		}
	}
}