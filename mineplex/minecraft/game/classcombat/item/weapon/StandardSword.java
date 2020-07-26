package mineplex.minecraft.game.classcombat.item.weapon;

import mineplex.minecraft.game.classcombat.item.Item;
import mineplex.minecraft.game.classcombat.item.ItemFactory;
import org.bukkit.Material;

public class StandardSword
  extends Item
{
  public StandardSword(ItemFactory factory, int gemCost, int tokenCost)
  {
    super(factory, "Standard Sword", new String[] { "Pretty standard." }, Material.IRON_SWORD, 1, true, gemCost, tokenCost);
    
    setFree(true);
  }
}
