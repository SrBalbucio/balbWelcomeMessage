package me.balbucio.welcome;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Main extends Plugin{
	private static Main instance;
	ArrayList<String> list_string = new ArrayList<String>();
	ArrayList<String> users = new ArrayList<String>();
	public String servidor = "";
	public boolean usarserver;
	
	public void onEnable() {
		setInstance(this);
		try {
			File file = new File(getDataFolder().getPath(), "config.yml");
			if(!getDataFolder().exists() || !file.exists()) {
				getDataFolder().mkdir();
				file.createNewFile();
				file.mkdir();
				Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
				ArrayList<String> string = new ArrayList<String>();
				config.set("EnviarEmUmServidorEspecifico", true);
				config.set("Servidor", "Lobby");
				string.add("");
				string.add("§b§lMEU SERVIDOR!");
				string.add("§aMinigames - PVP - Survival");
				string.add("");
				string.add("§aSeja bem vindo ao ServidorNetwork!");
				string.add("");
				config.set("msg", string);
				ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
			} 
			Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
			config.getList("msg");
			this.usarserver = config.getBoolean("EnviarEmUmServidorEspecifico");
			this.servidor = config.getString("Servidor");
			for(String s : config.getStringList("msg")) {
				list_string.add(s);
			}
			
		} catch(IOException e) {
			BungeeCord.getInstance().getConsole().sendMessage(new TextComponent("§c[BalbucioWelcome] Ocorreu um erro grave ao criar os arquivos!"));
			e.printStackTrace();
		}
		BungeeCord.getInstance().pluginManager.registerListener(this, new Evento());
		BungeeCord.getInstance().pluginManager.registerListener(this, new Switch());
		BungeeCord.getInstance().getConsole().sendMessage(new TextComponent("[BalbucioWelcomeMessage] §2Ativado com sucesso!"));
		BungeeCord.getInstance().getConsole().sendMessage(new TextComponent("[BalbucioWelcomeMessage] §bEstá precisando de uma hospedagem? Vem pra AntarcticCloud!"));
		
	}
	 public static Main getInstance() {
	        return instance;
	    }

	    private static void setInstance(final Main instance) {
	        Main.instance = instance;
	    }
		

}
