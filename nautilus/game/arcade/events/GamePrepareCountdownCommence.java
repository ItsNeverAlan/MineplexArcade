package nautilus.game.arcade.events;

import nautilus.game.arcade.game.Game;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class GamePrepareCountdownCommence
  extends Event
{
  private static final HandlerList handlers = new HandlerList();
  private Game _game;
  
  public GamePrepareCountdownCommence(Game game)
  {
    this._game = game;
  }
  
  public HandlerList getHandlers()
  {
    return handlers;
  }
  
  public static HandlerList getHandlerList()
  {
    return handlers;
  }
  
  public Game GetGame()
  {
    return this._game;
  }
}
