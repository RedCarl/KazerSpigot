package ga.windpvp.windspigot.knockback;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.sugarcanemc.sugarcane.util.yaml.YamlCommenter;

import com.google.common.base.Throwables;

import dev.cobblesword.nachospigot.knockback.KnockbackProfile;
import ga.windpvp.windspigot.WindSpigot;

public class KnockbackConfig {
	private static final Logger LOGGER = LogManager.getLogger(KnockbackConfig.class);
	private static File CONFIG_FILE;
	protected static final YamlCommenter c = new YamlCommenter();
	private static final String HEADER = "This is the knockback configuration file for WindSpigot.\n"
			+ "For configuration info see this: https://github.com/Wind-Development/WindSpigot/wiki/Knockback-Configuration";
	static YamlConfiguration config;

	private static volatile KnockbackProfile currentKb;
	private static final Set<KnockbackProfile> kbProfiles = new HashSet<>();

	public static void init(File configFile) {
		CONFIG_FILE = configFile;
		config = new YamlConfiguration();
		try {
			WindSpigot.LOGGER.info("Loading WindSpigot knockback config from " + configFile.getName());
			config.load(CONFIG_FILE);
		} catch (IOException ignored) {
		} catch (InvalidConfigurationException ex) {
			LOGGER.log(Level.ERROR, "Could not load knockback.yml, please correct your syntax errors", ex);
			throw Throwables.propagate(ex);
		}
		config.options().copyDefaults(true);
		c.setHeader(HEADER);

		Set<String> keys = getKeys("knockback.profiles");

		if (keys.size()==0) {
			final KnockbackProfile defaultProfile = new CraftKnockbackProfile("default");
			defaultProfile.save(true);
		}
		
		// Reload keys
		keys = getKeys("knockback.profiles");
		
		for (String key : keys) {

			final String path = "knockback.profiles." + key;

			CraftKnockbackProfile profile = (CraftKnockbackProfile) getKbProfileByName(key);

			if (profile == null) {
				profile = new CraftKnockbackProfile(key);
				kbProfiles.add(profile);
			}

			profile.setHorizontal(getDouble(path + ".horizontal", 0D));
			profile.setVertical(getDouble(path + ".vertical", 0D));
			profile.setVerticalLimit(getDouble(path + ".vertical-limit", 0D));
			profile.setExtraHorizontal(getDouble(path + ".extra-horizontal", 0D));
			profile.setExtraVertical(getDouble(path + ".extra-vertical", 0D));
			profile.setFrictionHorizontal(getDouble(path + ".friction-horizontal", 0D));
			profile.setFrictionVertical(getDouble(path + ".friction-vertical", 0D));
			profile.setSlowdown(getDouble(path + ".slowdown", 0D));

			profile.setSprintFrictionHorizontal(getDouble(path + ".sprint-friction-horizontal", 0D));
			profile.setSprintFrictionVertical(getDouble(path + ".sprint-friction-vertical", 0D));
			profile.setSprintVerticalLimit(getDouble(path + ".sprint-vertical-limit", 0D));
			profile.setSprintHorizontal(getDouble(path + ".sprint-horizontal", 0D));
			profile.setSprintVertical(getDouble(path + ".sprint-vertical", 0D));
			profile.setSprintExtraHorizontal(getDouble(path + ".sprint-extra-horizontal", 0D));
			profile.setSprintExtraVertical(getDouble(path + ".sprint-extra-vertical", 0D));
			profile.setStopSprint(getBoolean(path + ".stop-sprint", false));

			profile.setRodHorizontal(getDouble(path + ".projectiles.rod.horizontal", 0D));
			profile.setRodVertical(getDouble(path + ".projectiles.rod.vertical", 0D));
			profile.setRodSpeed(getDouble(path + ".projectiles.rod.speed", 0D));
			profile.setDoubleDamage(getBoolean(path + ".projectiles.rod.double-damage", false));

			profile.setArrowHorizontal(getDouble(path + ".projectiles.arrow.horizontal", 0D));
			profile.setArrowVertical(getDouble(path + ".projectiles.arrow.vertical", 0D));

			profile.setPearlHorizontal(getDouble(path + ".projectiles.pearl.horizontal", 0D));
			profile.setPearlVertical(getDouble(path + ".projectiles.pearl.vertical", 0D));

			profile.setSnowballHorizontal(getDouble(path + ".projectiles.snowball.horizontal", 0D));
			profile.setSnowballVertical(getDouble(path + ".projectiles.snowball.vertical", 0D));

			profile.setEggHorizontal(getDouble(path + ".projectiles.egg.horizontal", 0D));
			profile.setEggVertical(getDouble(path + ".projectiles.egg.vertical", 0D));

			profile.setPotionFall((float) getDouble(path + ".projectiles.potion.fall", 0D));
			profile.setPotionMultiplier((float) getDouble(path + ".projectiles.potion.multiplier", 0D));
			profile.setPotionOffset((float) getDouble(path + ".projectiles.potion.offset", 0D));
			profile.setPotionPlayerSpeed(getDouble(path + ".projectiles.potion.player-speed", 0D));
			profile.setPotionDistanceRadius(getDouble(path + ".projectiles.potion.distance-radius", 0D));
			profile.setSmoothPotting(getBoolean(path + ".projectiles.potion.smooth-potting", false));
		}
		currentKb = getKbProfileByName(getString("knockback.current", "default"));

		if (currentKb == null) {
			WindSpigot.LOGGER.warn("Knockback profile selected was not found, using profile 'default' for now!");
			currentKb = getKbProfileByName("default");
			
			WindSpigot.LOGGER.info("Setting default knockback as 'default'...");
			set("knockback.current", "default");
		}
		save();
	}

	public static KnockbackProfile getCurrentKb() {
		if (currentKb == null) {
			setCurrentKb(getKbProfileByName("default"));
		}
		return currentKb;
	}

	public static void setCurrentKb(KnockbackProfile kb) {
		currentKb = kb;
	}

	public static KnockbackProfile getKbProfileByName(String name) {
		for (KnockbackProfile profile : kbProfiles) {
			if (profile.getName().equalsIgnoreCase(name)) {
				return profile;
			}
		}
		return null;
	}

	public static Set<KnockbackProfile> getKbProfiles() {
		return kbProfiles;
	}

	public static void save() {
		try {
			config.save(CONFIG_FILE);
		} catch (IOException ex) {
			LOGGER.log(Level.ERROR, "Could not save " + CONFIG_FILE, ex);
		}
	}

	public static void set(String path, Object val) {
		config.set(path, val);

		save();
	}

	public static Set<String> getKeys(String path) {
		if (!config.isConfigurationSection(path)) {
			config.createSection(path);
			return new HashSet<>();
		}

		return config.getConfigurationSection(path).getKeys(false);
	}

	private static boolean getBoolean(String path, boolean def) {
		config.addDefault(path, def);
		return config.getBoolean(path, config.getBoolean(path));
	}

	private static double getDouble(String path, double def) {
		config.addDefault(path, def);
		return config.getDouble(path, config.getDouble(path));
	}

	private static float getFloat(String path, float def) {
		config.addDefault(path, def);
		return config.getFloat(path, config.getFloat(path));
	}

	private static int getInt(String path, int def) {
		config.addDefault(path, def);
		return config.getInt(path, config.getInt(path));
	}

	private static <T> List getList(String path, T def) {
		config.addDefault(path, def);
		return config.getList(path, config.getList(path));
	}

	private static String getString(String path, String def) {
		config.addDefault(path, def);
		return config.getString(path, config.getString(path));
	}
}
