package ru.mosigra.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserWantsToLearnEntityPK implements Serializable {
	private short userId;
	private short gameId;

	@Column(name = "user_id", nullable = false)
	@Id
	public short getUserId () {
		return userId;
	}

	public UserWantsToLearnEntityPK setUserId (short userId) {
		this.userId = userId;
		return this;
	}

	@Column(name = "game_id", nullable = false)
	@Id
	public short getGameId () {
		return gameId;
	}

	public UserWantsToLearnEntityPK setGameId (short gameId) {
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
		UserWantsToLearnEntityPK that = (UserWantsToLearnEntityPK)o;
		return userId == that.userId && gameId == that.gameId;
	}
}
