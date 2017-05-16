package ru.mosigra.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_event", schema = "public", catalog = "mosigra")
@IdClass(UserEventEntityPK.class)
public class UserEventEntity {
	private short userId;
	private short eventId;
	private Short placement;

	@Id
	@Column(name = "user_id", nullable = false)
	public short getUserId () {
		return userId;
	}

	public UserEventEntity setUserId (short userId) {
		this.userId = userId;
		return this;
	}

	@Id
	@Column(name = "event_id", nullable = false)
	public short getEventId () {
		return eventId;
	}

	public UserEventEntity setEventId (short eventId) {
		this.eventId = eventId;
		return this;
	}

	@Basic
	@Column(name = "placement", nullable = true)
	public Short getPlacement () {
		return placement;
	}

	public UserEventEntity setPlacement (Short placement) {
		this.placement = placement;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(userId, eventId, placement);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		UserEventEntity that = (UserEventEntity)o;
		return userId == that.userId && eventId == that.eventId
			&& Objects.equals(placement, that.placement);
	}
}
