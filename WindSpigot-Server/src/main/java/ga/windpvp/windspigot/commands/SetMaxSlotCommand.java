package ga.windpvp.windspigot.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

//[Nacho-0021] Add setMaxPlayers within Bukkit.getServer() and SetMaxSlot Command
public class SetMaxSlotCommand extends Command {
	public SetMaxSlotCommand(String name) {
		super(name);
		this.description = "Set the max slots for the server";
		this.usageMessage = "/sms [amount]";
		this.setAliases(Arrays.asList("smp", "setslots"));
		setPermission("windspigot.command.sms");
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		if (!testPermission(sender)) {
			return true;
		}
		if (args.length != 1) {
			sender.sendMessage(
					Color.GRAY + "There are currently " + Color.WHITE + Bukkit.getMaxPlayers() + Color.GRAY + " slots!");
			sender.sendMessage(
					ChatColor.RED + "Please use '/sms [amount]' to set the number of max slots for the server");
			return false;
		}
		int amount;
		try {
			amount = Integer.parseInt(args[0]);
		} catch (Exception ex) {
			sender.sendMessage(ChatColor.RED + "Please enter a number instead of '" + args[0] + "'.");
			return false;
		}
		Bukkit.getServer().setMaxPlayers(amount);
		sender.sendMessage(ChatColor.GREEN + "Player slots are now set at " + amount);
		return false;
	}
}
