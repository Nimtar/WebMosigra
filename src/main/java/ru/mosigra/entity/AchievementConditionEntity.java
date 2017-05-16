package ru.mosigra.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "achievement_condition", schema = "public", catalog = "mosigra")
@IdClass(AchievementConditionEntityPK.class)
class AchievementConditionEntity {
	private short achievementId;
	private short conditionId;
	private short rewardCount;

	@Id
	@Column(name = "achievement_id", nullable = false)
	public short getAchievementId () {
		return achievementId;
	}

	public AchievementConditionEntity setAchievementId (short achievementId) {
		this.achievementId = achievementId;
		return this;
	}

	@Id
	@Column(name = "condition_id", nullable = false)
	public short getConditionId () {
		return conditionId;
	}

	public AchievementConditionEntity setConditionId (short conditionId) {
		this.conditionId = conditionId;
		return this;
	}

	@Basic
	@Column(name = "reward_count", nullable = false)
	public short getRewardCount () {
		return rewardCount;
	}

	public AchievementConditionEntity setRewardCount (short rewardCount) {
		this.rewardCount = rewardCount;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(achievementId, conditionId, rewardCount);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		AchievementConditionEntity that = (AchievementConditionEntity)o;
		return achievementId == that.achievementId
			&& conditionId == that.conditionId
			&& rewardCount == that.rewardCount;
	}

	@Override
	public String toString () {
		return "AchievementConditionEntity {" + "achievementId=" +
			achievementId
			+ ", conditionId=" + conditionId + ", rewardCount=" + rewardCount
			+ " }";
	}
}
