package ru.mosigra.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserEventEntityPK implements Serializable {
	private short userId;
	private short eventId;

	@Column(name = "user_id", nullable = false)
	@Id
	public short getUserId () {
		return userId;
	}

	public UserEventEntityPK setUserId (short userId) {
		this.userId = userId;
		return this;
	}

	@Column(name = "event_id", nullable = false)
	@Id
	public short getEventId () {
		return eventId;
	}

	public UserEventEntityPK setEventId (short eventId) {
		this.eventId = eventId;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(userId, eventId);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		UserEventEntityPK that = (UserEventEntityPK)o;
		return userId == that.userId && eventId == that.eventId;
	}
}
