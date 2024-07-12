package net.sudologic.rivals.managers;

import net.sudologic.rivals.Faction;
import net.sudologic.rivals.Rivals;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EffectManager {
    /*todo
    - When a player kills another player, update their factions' penalties
     - Track faction penalties, with related methods.
    - Hourly update for effect cooldowns
    - If a player tries to clear their status effects, re-apply them
    - If a faction is denounced, sanctioned, or intervened, apply the appropriate effects
     */

    public void applyEffects(Player player, int intensity) {
        Faction f = Rivals.getFactionManager().getFactionByPlayer(player.getUniqueId());
        if (f == null) {
            return;
        }
        List<PotionEffect> effects = new ArrayList<>();
        if(intensity > 5) {
            effects.add(new PotionEffect(PotionEffectType.HUNGER, 20 * 60 * 60, intensity));
        }
        if(intensity > 4) {
            effects.add(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20 * 60 * 60, intensity));
        }
        if(intensity > 3) {
            effects.add(new PotionEffect(PotionEffectType.SLOW, 20 * 60 * 60, intensity));
        }
        if(intensity > 1) {
            effects.add(new PotionEffect(PotionEffectType.WEAKNESS, 20 * 60 * 60, intensity));
        }
        player.addPotionEffects(effects);
    }
}
