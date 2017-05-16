package ru.mosigra.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserAchievementEntityPK implements Serializable {
	private short userId;
	private short achievementId;

	@Column(name = "user_id", nullable = false)
	@Id
	public short getUserId () {
		return userId;
	}

	public UserAchievementEntityPK setUserId (short userId) {
		this.userId = userId;
		return this;
	}

	@Column(name = "achievement_id", nullable = false)
	@Id
	public short getAchievementId () {
		return achievementId;
	}

	public UserAchievementEntityPK setAchievementId (short achievementId) {
		this.achievementId = achievementId;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(userId, achievementId);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		UserAchievementEntityPK that = (UserAchievementEntityPK)o;
		return userId == that.userId && achievementId == that.achievementId;
	}
}
