package nautilus.game.arcade.game.games.paintball.kits;

import mineplex.core.common.util.C;
import mineplex.core.itemstack.ItemStackFactory;
import nautilus.game.arcade.ArcadeManager;
import nautilus.game.arcade.kit.Kit;
import nautilus.game.arcade.kit.KitAvailability;
import nautilus.game.arcade.kit.Perk;
import nautilus.game.arcade.kit.perks.PerkPaintballMachineGun;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.LeatherArmorMeta;













public class KitMachineGun
  extends Kit
{
  public KitMachineGun(ArcadeManager manager)
  {
    super(manager, "Machine Gun", KitAvailability.Blue, new String[] {"Full-automatic paintball gun.", C.cGold + "4 Hit Kill" }, new Perk[] {new PerkPaintballMachineGun() }, EntityType.ZOMBIE, new ItemStack(Material.DIAMOND_BARDING));
  }
  

  public void GiveItems(Player player)
  {
    player.getInventory().addItem(new ItemStack[] { ItemStackFactory.Instance.CreateStack(Material.DIAMOND_BARDING, 0, 1, "Paintball Machine Gun") });
    player.getInventory().addItem(new ItemStack[] { ItemStackFactory.Instance.CreateStack(Material.POTION, 0, 3, "Water Bomb") });
    
    ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
    LeatherArmorMeta metaHelm = (LeatherArmorMeta)helm.getItemMeta();
    metaHelm.setColor(Color.WHITE);
    helm.setItemMeta(metaHelm);
    player.getInventory().setHelmet(helm);
    
    ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
    LeatherArmorMeta meta = (LeatherArmorMeta)armor.getItemMeta();
    meta.setColor(Color.WHITE);
    armor.setItemMeta(meta);
    player.getInventory().setChestplate(armor);
    
    ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
    LeatherArmorMeta metaLegs = (LeatherArmorMeta)armor.getItemMeta();
    metaLegs.setColor(Color.WHITE);
    legs.setItemMeta(metaLegs);
    player.getInventory().setLeggings(legs);
    
    ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
    LeatherArmorMeta metaBoots = (LeatherArmorMeta)armor.getItemMeta();
    metaBoots.setColor(Color.WHITE);
    boots.setItemMeta(metaBoots);
    player.getInventory().setBoots(boots);
  }
}
