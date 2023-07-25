package ga.windpvp.windspigot.knockback;

import dev.cobblesword.nachospigot.knockback.KnockbackProfile;

public class CraftKnockbackProfile implements KnockbackProfile {

	/**
	 * Knockback名称
	 */
	private String name;

	/**
	 * 保存路径
	 */
	private final String saveProfilePath;

	/**
	 * 基础设置
	 */
	private double horizontal = 0.55D;
	private double vertical = 0.36D;
	private double verticalLimit = 0.36D;
	private double extraHorizontal = 0.5D;
	private double extraVertical = 0.1D;
	private double frictionHorizontal = 2.0D;
	private double frictionVertical = 2.0D;
	private double slowdown = 0.6D;

	/**
	 * 疾跑参数
	 */
	private double sprintFrictionHorizontal = 50.0D;
	private double sprintFrictionVertical = 50.0D;
	private double sprintVerticalLimit = 0.36D;
	private double sprintHorizontal = 0.55D;
	private double sprintVertical = 0.36D;
	private double sprintExtraHorizontal = 0.256D;
	private double sprintExtraVertical = 0.0D;
	private boolean stopSprint = true;

	/**
	 * 鱼竿
	 */
	private double rodHorizontal = 0.4D;
	private double rodVertical = 0.4D;
	private double rodSpeed = 1.02D;
	private boolean doubleDamage = false;

	/**
	 * 箭矢
	 */
	private double arrowHorizontal = 0.4D;
	private double arrowVertical = 0.4D;

	/**
	 * 珍珠
	 */
	private double pearlHorizontal = 0.4D;
	private double pearlVertical = 0.4D;

	/**
	 * 雪球
	 */
	private double snowballHorizontal = 0.4D;
	private double snowballVertical = 0.4D;

	/**
	 * 鸡蛋
	 */
	private double eggHorizontal = 0.4D;
	private double eggVertical = 0.4D;

	/**
	 * 药水
	 */
	private float potionFall = 0.06F;
	private float potionMultiplier = 0.5F;
	private float potionOffset = -20.0F;
	private double potionPlayerSpeed = 4D;
	private double potionDistanceRadius = 0.1D;
	private boolean smoothPotting = true;

	public CraftKnockbackProfile(String name) {
		this.name = name;
		this.saveProfilePath = "knockback.profiles." + this.name;
	}

	private void set(String savePath, Object value) {
		KnockbackConfig.set(saveProfilePath + savePath, value);
	}

	@Override
	public void save() {
		save(false);
	}

	@Override
	public void save(boolean projectiles) {

		set(".horizontal", this.horizontal);
		set(".vertical", this.vertical);
		set(".vertical-limit", this.verticalLimit);
		set(".extra-horizontal", this.extraHorizontal);
		set(".extra-vertical", this.extraVertical);
		set(".friction-horizontal", this.frictionHorizontal);
		set(".friction-vertical", this.frictionVertical);

		set(".sprint-friction-horizontal", this.sprintFrictionHorizontal);
		set(".sprint-friction-vertical", this.sprintFrictionVertical);
		set(".sprint-vertical-limit", this.sprintVerticalLimit);
		set(".sprint-horizontal", this.sprintHorizontal);
		set(".sprint-vertical", this.sprintVertical);
		set(".sprint-extra-horizontal", this.sprintExtraHorizontal);
		set(".sprint-extra-vertical", this.sprintExtraVertical);
		set(".stop-sprint", this.stopSprint);

		set(".slowdown", this.slowdown);

		if (projectiles) {

			set(".projectiles.rod.horizontal", this.rodHorizontal);
			set(".projectiles.rod.vertical", this.rodVertical);
			set(".projectiles.rod.speed", this.rodSpeed);
			set(".projectiles.rod.double-damage", this.doubleDamage);

			set(".projectiles.arrow.horizontal", this.arrowHorizontal);
			set(".projectiles.arrow.vertical", this.arrowVertical);

			set(".projectiles.pearl.horizontal", this.pearlHorizontal);
			set(".projectiles.pearl.vertical", this.pearlVertical);

			set(".projectiles.snowball.horizontal", this.snowballHorizontal);
			set(".projectiles.snowball.vertical", this.snowballVertical);

			set(".projectiles.egg.horizontal", this.eggHorizontal);
			set(".projectiles.egg.vertical", this.eggVertical);

			set(".projectiles.potion.fall", this.potionFall);
			set(".projectiles.potion.multiplier", this.potionMultiplier);
			set(".projectiles.potion.offset", this.potionOffset);
			set(".projectiles.potion.player-speed", this.potionPlayerSpeed);
			set(".projectiles.potion.distance-radius", this.potionDistanceRadius);
			set(".projectiles.potion.smooth-potting", this.smoothPotting);

		}

		KnockbackConfig.save();

	}

	@Override
	public String[] getKnockbackValues() {

		return new String[] {

				"Horizontal§7: " + this.horizontal,
				"Vertical§7: " + this.vertical,
				"Vertical-Limit§7: " + this.verticalLimit,
				"Extra-Horizontal§7: " + this.extraHorizontal,
				"Extra-Vertical§7: " + this.extraVertical,
				"Friction-Horizontal§7: " + this.frictionHorizontal,
				"Friction-Vertical§7: " + this.frictionVertical,

				"Sprint-Friction-Horizontal§7: " + this.sprintFrictionHorizontal,
				"Sprint-Friction-Vertical§7: " + this.sprintFrictionVertical,
				"Sprint-Vertical-Limit§7: " + this.sprintVerticalLimit,
				"Sprint-Horizontal§7: " + this.sprintHorizontal,
				"Sprint-Vertical§7: " + this.sprintVertical,
				"Sprint-Extra-Horizontal§7: " + this.sprintExtraHorizontal,
				"Sprint-Extra-Vertical§7: " + this.sprintExtraVertical,
				"Stop-Sprint§7: " + this.stopSprint,

				"Slowdown§7: " + this.slowdown,

		};
	}

	@Override
	public String[] getProjectilesValues() {
		return new String[] {

				"Rod-Horizontal§7: " + this.rodHorizontal,
				"Rod-Vertical§7: " + this.rodVertical,
				"Rod-Speed§7: " + this.rodSpeed,
				"Double-Damage§7: " + this.doubleDamage,

				"Arrow-Horizontal§7: " + this.arrowHorizontal,
				"Arrow-Vertical§7: " + this.arrowVertical,

				"Pearl-Horizontal§7: " + this.pearlHorizontal,
				"Pearl-Vertical§7: " + this.pearlVertical,

				"Snowball-Horizontal§7: " + this.snowballHorizontal,
				"Snowball-Vertical§7: " + this.snowballVertical,

				"Egg-Horizontal§7: " + this.eggHorizontal,
				"Egg-Vertical§7: " + this.eggVertical,

				"Potion-Fall§7: " + this.potionFall,
				"Potion-Multiplier§7: " + this.potionMultiplier,
				"Potion-Offset§7: " + this.potionOffset,
				"Potion-Player-Speed§7: " + this.potionPlayerSpeed,
				"Potion-Distance-Radius§7: " + this.potionDistanceRadius,
				"Smooth-Potting§7: " + this.smoothPotting

		};
	}


	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getHorizontal() {
		return horizontal;
	}

	@Override
	public void setHorizontal(double horizontal) {
		this.horizontal = horizontal;
	}

	@Override
	public double getVertical() {
		return vertical;
	}

	@Override
	public void setVertical(double vertical) {
		this.vertical = vertical;
	}

	@Override
	public double getVerticalLimit() {
		return verticalLimit;
	}

	@Override
	public void setVerticalLimit(double verticalLimit) {
		this.verticalLimit = verticalLimit;
	}

	@Override
	public double getExtraHorizontal() {
		return extraHorizontal;
	}

	@Override
	public void setExtraHorizontal(double extraHorizontal) {
		this.extraHorizontal = extraHorizontal;
	}

	@Override
	public double getExtraVertical() {
		return extraVertical;
	}

	@Override
	public void setExtraVertical(double extraVertical) {
		this.extraVertical = extraVertical;
	}

	@Override
	public double getFrictionHorizontal() {
		return frictionHorizontal;
	}

	@Override
	public void setFrictionHorizontal(double frictionHorizontal) {
		this.frictionHorizontal = frictionHorizontal;
	}

	@Override
	public double getFrictionVertical() {
		return frictionVertical;
	}

	@Override
	public void setFrictionVertical(double frictionVertical) {
		this.frictionVertical = frictionVertical;
	}

	@Override
	public double getRodHorizontal() {
		return rodHorizontal;
	}

	@Override
	public void setRodHorizontal(double rodHorizontal) {
		this.rodHorizontal = rodHorizontal;
	}

	@Override
	public double getRodVertical() {
		return rodVertical;
	}

	@Override
	public void setRodVertical(double rodVertical) {
		this.rodVertical = rodVertical;
	}

	@Override
	public double getRodSpeed() {
		return rodSpeed;
	}

	@Override
	public void setRodSpeed(double rodSpeed) {
		this.rodSpeed = rodSpeed;
	}

	@Override
	public double getArrowHorizontal() {
		return arrowHorizontal;
	}

	@Override
	public void setArrowHorizontal(double arrowHorizontal) {
		this.arrowHorizontal = arrowHorizontal;
	}

	@Override
	public double getArrowVertical() {
		return arrowVertical;
	}

	@Override
	public void setArrowVertical(double arrowVertical) {
		this.arrowVertical = arrowVertical;
	}

	@Override
	public double getSlowdown() {
		return slowdown;
	}

	@Override
	public void setSlowdown(double slowdown) {
		this.slowdown = slowdown;
	}

	@Override
	public double getPearlHorizontal() {
		return pearlHorizontal;
	}

	@Override
	public void setPearlHorizontal(double pearlHorizontal) {
		this.pearlHorizontal = pearlHorizontal;
	}

	@Override
	public double getPearlVertical() {
		return pearlVertical;
	}

	@Override
	public void setPearlVertical(double pearlVertical) {
		this.pearlVertical = pearlVertical;
	}

	@Override
	public double getSnowballHorizontal() {
		return snowballHorizontal;
	}

	@Override
	public void setSnowballHorizontal(double snowballHorizontal) {
		this.snowballHorizontal = snowballHorizontal;
	}

	@Override
	public double getSnowballVertical() {
		return snowballVertical;
	}

	@Override
	public void setSnowballVertical(double snowballVertical) {
		this.snowballVertical = snowballVertical;
	}

	@Override
	public double getEggHorizontal() {
		return eggHorizontal;
	}

	@Override
	public void setEggHorizontal(double eggHorizontal) {
		this.eggHorizontal = eggHorizontal;
	}

	@Override
	public double getEggVertical() {
		return eggVertical;
	}

	@Override
	public void setEggVertical(double eggVertical) {
		this.eggVertical = eggVertical;
	}

	@Override
	public float getPotionFall() {
		return potionFall;
	}

	@Override
	public void setPotionFall(float potionFall) {
		this.potionFall = potionFall;
	}

	@Override
	public float getPotionMultiplier() {
		return potionMultiplier;
	}

	@Override
	public void setPotionMultiplier(float potionMultiplier) {
		this.potionMultiplier = potionMultiplier;
	}

	@Override
	public float getPotionOffset() {
		return potionOffset;
	}

	@Override
	public void setPotionOffset(float potionOffset) {
		this.potionOffset = potionOffset;
	}

	@Override
	public double getPotionPlayerSpeed() {
		return potionPlayerSpeed;
	}

	@Override
	public void setPotionPlayerSpeed(double potionPlayerSpeed) {
		this.potionPlayerSpeed = potionPlayerSpeed;
	}

	@Override
	public double getPotionDistanceRadius() {
		return potionDistanceRadius;
	}

	@Override
	public void setPotionDistanceRadius(double potionDistanceRadius) {
		this.potionDistanceRadius = potionDistanceRadius;
	}

	@Override
	public boolean isSmoothPotting() {
		return smoothPotting;
	}

	@Override
	public void setSmoothPotting(boolean smoothPotting) {
		this.smoothPotting = smoothPotting;
	}

	@Override
	public double getSprintFrictionHorizontal() {
		return sprintFrictionHorizontal;
	}

	@Override
	public void setSprintFrictionHorizontal(double sprintFrictionHorizontal) {
		this.sprintFrictionHorizontal = sprintFrictionHorizontal;
	}

	@Override
	public double getSprintFrictionVertical() {
		return sprintFrictionVertical;
	}

	@Override
	public void setSprintFrictionVertical(double sprintFrictionVertical) {
		this.sprintFrictionVertical = sprintFrictionVertical;
	}

	@Override
	public double getSprintVerticalLimit() {
		return sprintVerticalLimit;
	}

	@Override
	public void setSprintVerticalLimit(double sprintVerticalLimit) {
		this.sprintVerticalLimit = sprintVerticalLimit;
	}

	@Override
	public double getSprintHorizontal() {
		return sprintHorizontal;
	}

	@Override
	public void setSprintHorizontal(double sprintHorizontal) {
		this.sprintHorizontal = sprintHorizontal;
	}

	@Override
	public double getSprintVertical() {
		return sprintVertical;
	}

	@Override
	public void setSprintVertical(double sprintVertical) {
		this.sprintVertical = sprintVertical;
	}

	@Override
	public double getSprintExtraHorizontal() {
		return sprintExtraHorizontal;
	}

	@Override
	public void setSprintExtraHorizontal(double sprintExtraHorizontal) {
		this.sprintExtraHorizontal = sprintExtraHorizontal;
	}

	@Override
	public double getSprintExtraVertical() {
		return sprintExtraVertical;
	}

	@Override
	public void setSprintExtraVertical(double sprintExtraVertical) {
		this.sprintExtraVertical = sprintExtraVertical;
	}

	@Override
	public boolean isStopSprint() {
		return stopSprint;
	}

	@Override
	public void setStopSprint(boolean stopSprint) {
		this.stopSprint = stopSprint;
	}

	@Override
	public boolean isDoubleDamage() {
		return doubleDamage;
	}

	@Override
	public void setDoubleDamage(boolean doubleDamage) {
		this.doubleDamage = doubleDamage;
	}
}
