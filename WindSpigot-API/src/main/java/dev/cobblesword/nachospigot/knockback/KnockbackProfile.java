package dev.cobblesword.nachospigot.knockback;

public interface KnockbackProfile {
	String getName();

	void setName(String name);

	double getHorizontal();

	void setHorizontal(double horizontal);

	double getVertical();

	void setVertical(double vertical);

	double getVerticalLimit();

	void setVerticalLimit(double verticalLimit);

	double getExtraHorizontal();

	void setExtraHorizontal(double extraHorizontal);

	double getExtraVertical();

	void setExtraVertical(double extraVertical);

	double getFrictionHorizontal();

	void setFrictionHorizontal(double frictionHorizontal);

	double getFrictionVertical();

	void setFrictionVertical(double frictionVertical);

	double getRodHorizontal();

	void setRodHorizontal(double rodHorizontal);

	double getRodVertical();

	void setRodVertical(double rodVertical);

	double getRodSpeed();

	void setRodSpeed(double rodSpeed);

	double getArrowHorizontal();

	void setArrowHorizontal(double arrowHorizontal);

	double getArrowVertical();

	void setArrowVertical(double arrowVertical);

	double getSlowdown();

	void setSlowdown(double slowdown);

	double getPearlHorizontal();

	void setPearlHorizontal(double pearlHorizontal);

	double getPearlVertical();

	void setPearlVertical(double pearlVertical);

	double getSnowballHorizontal();

	void setSnowballHorizontal(double snowballHorizontal);

	double getSnowballVertical();

	void setSnowballVertical(double snowballVertical);

	double getEggHorizontal();

	void setEggHorizontal(double eggHorizontal);

	double getEggVertical();

	void setEggVertical(double eggVertical);

	float getPotionFall();

	void setPotionFall(float potionFall);

	float getPotionMultiplier();

	void setPotionMultiplier(float potionMultiplier);

	float getPotionOffset();

	void setPotionOffset(float potionOffset);

	double getPotionPlayerSpeed();

	void setPotionPlayerSpeed(double potionPlayerSpeed);

	double getPotionDistanceRadius();

	void setPotionDistanceRadius(double potionDistanceRadius);

	boolean isSmoothPotting();

	void setSmoothPotting(boolean smoothPotting);

	double getSprintFrictionHorizontal();

	void setSprintFrictionHorizontal(double sprintFrictionHorizontal);

	double getSprintFrictionVertical();

	void setSprintFrictionVertical(double sprintFrictionVertical);

	double getSprintVerticalLimit();

	void setSprintVerticalLimit(double sprintVerticalLimit);

	double getSprintHorizontal();

	void setSprintHorizontal(double sprintHorizontal);

	double getSprintVertical();

	void setSprintVertical(double sprintVertical);

	double getSprintExtraHorizontal();

	void setSprintExtraHorizontal(double sprintExtraHorizontal);

	double getSprintExtraVertical();

	void setSprintExtraVertical(double sprintExtraVertical);

	boolean isStopSprint();

	void setStopSprint(boolean stopSprint);

	boolean isDoubleDamage();

	void setDoubleDamage(boolean doubleDamage);

	void save();

	void save(boolean projectiles);

	String[] getKnockbackValues();

	String[] getProjectilesValues();
}
