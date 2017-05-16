package ru.mosigra.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_achievement", schema = "public", catalog = "mosigra")
@IdClass(UserAchievementEntityPK.class)
public class UserAchievementEntity {
	private short userId;
	private short achievementId;
	private Short achievementProgress;

	@Id
	@Column(name = "user_id", nullable = false)
	public short getUserId () {
		return userId;
	}

	public UserAchievementEntity setUserId (short userId) {
		this.userId = userId;
		return this;
	}

	@Id
	@Column(name = "achievement_id", nullable = false)
	public short getAchievementId () {
		return achievementId;
	}

	public UserAchievementEntity setAchievementId (short achievementId) {
		this.achievementId = achievementId;
		return this;
	}

	@Basic
	@Column(name = "achievement_progress", nullable = true)
	public Short getAchievementProgress () {
		return achievementProgress;
	}

	public UserAchievementEntity setAchievementProgress (
		Short achievementProgress) {
		this.achievementProgress = achievementProgress;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(userId, achievementId, achievementProgress);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		UserAchievementEntity that = (UserAchievementEntity)o;
		return userId == that.userId && achievementId == that.achievementId
			&& Objects.equals(achievementProgress, that.achievementProgress);
	}
}
