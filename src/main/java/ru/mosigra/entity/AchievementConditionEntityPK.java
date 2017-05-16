package ru.mosigra.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AchievementConditionEntityPK implements Serializable {
	private short achievementId;
	private short conditionId;

	@Column(name = "achievement_id", nullable = false)
	@Id
	public short getAchievementId () {
		return achievementId;
	}

	public AchievementConditionEntityPK setAchievementId (short
		achievementId) {
		this.achievementId = achievementId;
		return this;
	}

	@Column(name = "condition_id", nullable = false)
	@Id
	public short getConditionId () {
		return conditionId;
	}

	public AchievementConditionEntityPK setConditionId (short conditionId) {
		this.conditionId = conditionId;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(achievementId, conditionId);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		AchievementConditionEntityPK that = (AchievementConditionEntityPK)o;
		return achievementId == that.achievementId
			&& conditionId == that.conditionId;
	}
}
