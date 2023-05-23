package org.bukkit.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

import dev.cobblesword.nachospigot.knockback.KnockbackProfile;

/**
 * Represents a living entity, such as a monster or player
 */
public interface LivingEntity extends Entity, Damageable, ProjectileSource {

	/**
	 * Gets the height of the living entity's eyes above its Location.
	 *
	 * @return height of the living entity's eyes above its location
	 */
    double getEyeHeight();

	/**
	 * Gets the height of the living entity's eyes above its Location.
	 *
	 * @param ignoreSneaking if set to true, the effects of sneaking will be ignored
	 * @return height of the living entity's eyes above its location
	 */
    double getEyeHeight(boolean ignoreSneaking);

	/**
	 * Get a Location detailing the current eye position of the living entity.
	 *
	 * @return a location at the eyes of the living entity
	 */
    Location getEyeLocation();

	/**
	 * Gets all blocks along the living entity's line of sight.
	 * <p>
	 * This list contains all blocks from the living entity's eye position to target
	 * inclusive.
	 *
	 * @param transparent HashSet containing all transparent block IDs (set to null
	 *                    for only air)
	 * @param maxDistance this is the maximum distance to scan (may be limited by
	 *                    server by at least 100 blocks, no less)
	 * @return list containing all blocks along the living entity's line of sight
	 * @deprecated Magic value
	 */
	@Deprecated
    List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance);

	/**
	 * Gets all blocks along the living entity's line of sight.
	 * <p>
	 * This list contains all blocks from the living entity's eye position to target
	 * inclusive.
	 *
	 * @param transparent HashSet containing all transparent block Materials (set to
	 *                    null for only air)
	 * @param maxDistance this is the maximum distance to scan (may be limited by
	 *                    server by at least 100 blocks, no less)
	 * @return list containing all blocks along the living entity's line of sight
	 */
    List<Block> getLineOfSight(Set<Material> transparent, int maxDistance);

	/**
	 * Gets the block that the living entity has targeted.
	 *
	 * @param transparent HashSet containing all transparent block IDs (set to null
	 *                    for only air)
	 * @param maxDistance this is the maximum distance to scan (may be limited by
	 *                    server by at least 100 blocks, no less)
	 * @return block that the living entity has targeted
	 * @deprecated Magic value
	 */
	@Deprecated
    Block getTargetBlock(HashSet<Byte> transparent, int maxDistance);

	/**
	 * Gets the block that the living entity has targeted.
	 *
	 * @param transparent HashSet containing all transparent block Materials (set to
	 *                    null for only air)
	 * @param maxDistance this is the maximum distance to scan (may be limited by
	 *                    server by at least 100 blocks, no less)
	 * @return block that the living entity has targeted
	 */
    Block getTargetBlock(Set<Material> transparent, int maxDistance);

	/**
	 * Gets the last two blocks along the living entity's line of sight.
	 * <p>
	 * The target block will be the last block in the list.
	 *
	 * @param transparent HashSet containing all transparent block IDs (set to null
	 *                    for only air)
	 * @param maxDistance this is the maximum distance to scan. This may be further
	 *                    limited by the server, but never to less than 100 blocks
	 * @return list containing the last 2 blocks along the living entity's line of
	 *         sight
	 * @deprecated Magic value
	 */
	@Deprecated
    List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance);

	/**
	 * Gets the last two blocks along the living entity's line of sight.
	 * <p>
	 * The target block will be the last block in the list.
	 *
	 * @param transparent HashSet containing all transparent block Materials (set to
	 *                    null for only air)
	 * @param maxDistance this is the maximum distance to scan. This may be further
	 *                    limited by the server, but never to less than 100 blocks
	 * @return list containing the last 2 blocks along the living entity's line of
	 *         sight
	 */
    List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance);

	/**
	 * Throws an egg from the living entity.
	 *
	 * @deprecated use launchProjectile(Egg.class) instead
	 * @return the egg thrown
	 */
	@Deprecated
    Egg throwEgg();

	/**
	 * Throws a snowball from the living entity.
	 *
	 * @deprecated use launchProjectile(Snowball.class) instead
	 * @return the snowball thrown
	 */
	@Deprecated
    Snowball throwSnowball();

	/**
	 * Shoots an arrow from the living entity.
	 *
	 * @deprecated use launchProjectile(Arrow.class) instead
	 * @return the arrow shot
	 */
	@Deprecated
    Arrow shootArrow();

	/**
	 * Returns the amount of air that the living entity has remaining, in ticks.
	 *
	 * @return amount of air remaining
	 */
    int getRemainingAir();

	/**
	 * Sets the amount of air that the living entity has remaining, in ticks.
	 *
	 * @param ticks amount of air remaining
	 */
    void setRemainingAir(int ticks);

	/**
	 * Returns the maximum amount of air the living entity can have, in ticks.
	 *
	 * @return maximum amount of air
	 */
    int getMaximumAir();

	/**
	 * Sets the maximum amount of air the living entity can have, in ticks.
	 *
	 * @param ticks maximum amount of air
	 */
    void setMaximumAir(int ticks);

	/**
	 * Returns the living entity's current maximum no damage ticks.
	 * <p>
	 * This is the maximum duration in which the living entity will not take damage.
	 *
	 * @return maximum no damage ticks
	 */
    int getMaximumNoDamageTicks();

	/**
	 * Sets the living entity's current maximum no damage ticks.
	 *
	 * @param ticks maximum amount of no damage ticks
	 */
    void setMaximumNoDamageTicks(int ticks);

	/**
	 * Returns the living entity's last damage taken in the current no damage ticks
	 * time.
	 * <p>
	 * Only damage higher than this amount will further damage the living entity.
	 *
	 * @return damage taken since the last no damage ticks time period
	 */
    double getLastDamage();

	/**
	 * This method exists for legacy reasons to provide backwards compatibility. It
	 * will not exist at runtime and should not be used under any circumstances.
	 * 
	 * @return damage taken since the last no damage ticks time period
	 */
	@Deprecated
    int _INVALID_getLastDamage();

	/**
	 * Sets the damage dealt within the current no damage ticks time period.
	 *
	 * @param damage amount of damage
	 */
    void setLastDamage(double damage);

	/**
	 * This method exists for legacy reasons to provide backwards compatibility. It
	 * will not exist at runtime and should not be used under any circumstances.
	 * 
	 * @param damage amount of damage
	 */
	@Deprecated
    void _INVALID_setLastDamage(int damage);

	/**
	 * Returns the living entity's current no damage ticks.
	 *
	 * @return amount of no damage ticks
	 */
    int getNoDamageTicks();

	/**
	 * Sets the living entity's current no damage ticks.
	 *
	 * @param ticks amount of no damage ticks
	 */
    void setNoDamageTicks(int ticks);

	/**
	 * Gets the knockback profile of this player.
	 */
	KnockbackProfile getKnockbackProfile();

	/**
	 * Sets the knockback profile of this player. The player's knockback profile
	 * overrides the global knockback profile.
	 */
	void setKnockbackProfile(KnockbackProfile profile);

	/**
	 * Gets the player identified as the killer of the living entity.
	 * <p>
	 * May be null.
	 *
	 * @return killer player, or null if none found
	 */
    Player getKiller();

	/**
	 * Adds the given {@link PotionEffect} to the living entity.
	 * <p>
	 * Only one potion effect can be present for a given {@link PotionEffectType}.
	 *
	 * @param effect PotionEffect to be added
	 * @return whether the effect could be added
	 */
    boolean addPotionEffect(PotionEffect effect);

	/**
	 * Adds the given {@link PotionEffect} to the living entity.
	 * <p>
	 * Only one potion effect can be present for a given {@link PotionEffectType}.
	 *
	 * @param effect PotionEffect to be added
	 * @param force  whether conflicting effects should be removed
	 * @return whether the effect could be added
	 */
    boolean addPotionEffect(PotionEffect effect, boolean force);

	/**
	 * Attempts to add all of the given {@link PotionEffect} to the living entity.
	 *
	 * @param effects the effects to add
	 * @return whether all of the effects could be added
	 */
    boolean addPotionEffects(Collection<PotionEffect> effects);

	/**
	 * Returns whether the living entity already has an existing effect of the given
	 * {@link PotionEffectType} applied to it.
	 *
	 * @param type the potion type to check
	 * @return whether the living entity has this potion effect active on them
	 */
    boolean hasPotionEffect(PotionEffectType type);

	/**
	 * Removes any effects present of the given {@link PotionEffectType}.
	 *
	 * @param type the potion type to remove
	 */
    void removePotionEffect(PotionEffectType type);

	/**
	 * Returns all currently active {@link PotionEffect}s on the living entity.
	 *
	 * @return a collection of {@link PotionEffect}s
	 */
    Collection<PotionEffect> getActivePotionEffects();

	/**
	 * Checks whether the living entity has block line of sight to another.
	 * <p>
	 * This uses the same algorithm that hostile mobs use to find the closest
	 * player.
	 *
	 * @param other the entity to determine line of sight to
	 * @return true if there is a line of sight, false if not
	 */
    boolean hasLineOfSight(Entity other);
	
	// WindSpigot start
	/**
	 * Checks whether the living entity has block line of sight to a location.
	 * <p>
	 *
	 * @param location the location to determine line of sight to
	 * @return true if there is a line of sight, false if not
	 */
    boolean hasLineOfSight(Location location);
	// WindSpigot end
	
	/**
	 * Returns if the living entity despawns when away from players or not.
	 * <p>
	 * By default, animals are not removed while other mobs are.
	 *
	 * @return true if the living entity is removed when away from players
	 */
    boolean getRemoveWhenFarAway();

	/**
	 * Sets whether or not the living entity despawns when away from players or not.
	 *
	 * @param remove the removal status
	 */
    void setRemoveWhenFarAway(boolean remove);

	/**
	 * Gets the inventory with the equipment worn by the living entity.
	 *
	 * @return the living entity's inventory
	 */
    EntityEquipment getEquipment();

	/**
	 * Sets whether or not the living entity can pick up items.
	 *
	 * @param pickup whether or not the living entity can pick up items
	 */
    void setCanPickupItems(boolean pickup);

	/**
	 * Gets if the living entity can pick up items.
	 *
	 * @return whether or not the living entity can pick up items
	 */
    boolean getCanPickupItems();

	/**
	 * Returns whether the entity is currently leashed.
	 *
	 * @return whether the entity is leashed
	 */
    boolean isLeashed();

	/**
	 * Gets the entity that is currently leading this entity.
	 *
	 * @return the entity holding the leash
	 * @throws IllegalStateException if not currently leashed
	 */
    Entity getLeashHolder() throws IllegalStateException;

	/**
	 * Sets the leash on this entity to be held by the supplied entity.
	 * <p>
	 * This method has no effect on EnderDragons, Withers, Players, or Bats.
	 * Non-living entities excluding leashes will not persist as leash holders.
	 *
	 * @param holder the entity to leash this entity to
	 * @return whether the operation was successful
	 */
    boolean setLeashHolder(Entity holder);

	// Paper start
	/**
	 * Get the number of arrows stuck in this entity
	 *
	 * @return Number of arrows stuck
	 */
	int getArrowsStuck();

	/**
	 * Set the number of arrows stuck in this entity
	 *
	 * @param arrows Number of arrows to stick in this entity
	 */
	void setArrowsStuck(int arrows);
	// Paper end

	// Nacho start
    boolean shouldBreakLeash();

	void setShouldBreakLeash(boolean shouldBreakLeash);

	boolean shouldPullWhileLeashed();

	void setPullWhileLeashed(boolean pullWhileLeashed);
	// Nacho end
}
