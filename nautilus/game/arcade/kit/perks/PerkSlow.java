package nautilus.game.arcade.kit.perks;

import mineplex.core.common.util.C;
import mineplex.core.updater.event.UpdateEvent;
import mineplex.minecraft.game.core.condition.ConditionFactory;
import mineplex.minecraft.game.core.condition.ConditionManager;
import nautilus.game.arcade.ArcadeManager;
import nautilus.game.arcade.game.Game;
import nautilus.game.arcade.kit.Kit;
import nautilus.game.arcade.kit.Perk;
import org.bukkit.entity.Player;

public class PerkSlow extends Perk
{
  private int _level;
  
  public PerkSlow(int level)
  {
    super("Slow", new String[] {C.cGray + "Permanent Slow " + (level + 1) });
    

    this._level = level;
  }
  
  @org.bukkit.event.EventHandler
  public void DigSpeed(UpdateEvent event)
  {
    if (event.getType() != mineplex.core.updater.UpdateType.SLOW) {
      return;
    }
    if (this.Manager.GetGame() == null) {
      return;
    }
    for (Player player : this.Manager.GetGame().GetPlayers(true))
    {
      if (this.Kit.HasKit(player))
      {

        this.Manager.GetCondition().Factory().Slow(GetName(), player, player, 8.0D, this._level, false, false, false, false);
      }
    }
  }
}
