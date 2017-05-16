package ru.mosigra.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_wants_to_learn", schema = "public", catalog = "mosigra")
@IdClass(UserWantsToLearnEntityPK.class)
public class UserWantsToLearnEntity {
	private short userId;
	private short gameId;

	@Id
	@Column(name = "user_id", nullable = false)
	public short getUserId () {
		return userId;
	}

	public UserWantsToLearnEntity setUserId (short userId) {
		this.userId = userId;
		return this;
	}

	@Id
	@Column(name = "game_id", nullable = false)
	public short getGameId () {
		return gameId;
	}

	public UserWantsToLearnEntity setGameId (short gameId) {
		this.gameId = gameId;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(userId, gameId);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		UserWantsToLearnEntity that = (UserWantsToLearnEntity)o;
		return userId == that.userId && gameId == that.gameId;
	}
}
