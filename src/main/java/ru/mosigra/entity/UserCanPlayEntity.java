package ru.mosigra.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_can_play", schema = "public", catalog = "mosigra")
@IdClass(UserCanPlayEntityPK.class)
public class UserCanPlayEntity {
	private short userId;
	private short gameId;

	@Id
	@Column(name = "user_id", nullable = false)
	public short getUserId () {
		return userId;
	}

	public UserCanPlayEntity setUserId (short userId) {
		this.userId = userId;
		return this;
	}

	@Id
	@Column(name = "game_id", nullable = false)
	public short getGameId () {
		return gameId;
	}

	public UserCanPlayEntity setGameId (short gameId) {
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
		UserCanPlayEntity that = (UserCanPlayEntity)o;
		return userId == that.userId && gameId == that.gameId;
	}
}
