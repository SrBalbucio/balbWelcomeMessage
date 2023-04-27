package me.balbucio.welcome;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Switch implements Listener{
	
	@EventHandler
	public void onServerSwitch(final ServerSwitchEvent serverSwitchEvent)  {
		ProxiedPlayer p = serverSwitchEvent.getPlayer();
		ServerInfo from = p.getServer().getInfo();
		
		if(from.getName() == Main.getInstance().servidor) {
		if(Main.getInstance().users.contains(p.getName())) {
			for(String s : Main.getInstance().list_string) {
			      p.sendMessage(new TextComponent(s));
				}
			Main.getInstance().users.remove(p.getName());
		} else {
			BungeeCord.getInstance().getOnlineCount();
		}
	} 

}
}
