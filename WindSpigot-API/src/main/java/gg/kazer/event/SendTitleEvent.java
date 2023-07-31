package gg.kazer.event;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.github.paperspigot.Title;

public class SendTitleEvent extends Event implements Cancellable {
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;



	private final Player player;
	private final String title;
	private final String subtitle;
	private final int fadeIn;
	private final int stay;
	private final int fadeOut;

	public SendTitleEvent(Player player, String title,String subtitle) {
		this.player = player;
		this.title = title;
		this.subtitle= subtitle;
		this.fadeIn = 1;
		this.stay = 2;
		this.fadeOut = 1;
	}
	public SendTitleEvent(Player player, Title title) {
		this.player = player;
		this.title = BaseComponent.toLegacyText(title.getTitle());
		this.subtitle= BaseComponent.toLegacyText(title.getSubtitle());
		this.fadeIn = title.getFadeIn();
		this.stay = title.getStay();
		this.fadeOut = title.getFadeOut();
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}


	public Player getPlayer(){
		return player;
	}
	public String getTitle() {
		return title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public int getFadeIn() {
		return fadeIn;
	}
	public int getStay() {
		return stay;
	}
	public int getFadeOut() {
		return fadeOut;
	}


	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
