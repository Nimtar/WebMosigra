package ru.mosigra.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event_type", schema = "public", catalog = "mosigra")
public class EventTypeEntity {
	private short id;
	private String name;
	private String description;

	@Id
	@Column(name = "id", nullable = false)
	public short getId () {
		return id;
	}

	public EventTypeEntity setId (short id) {
		this.id = id;
		return this;
	}

	@Basic
	@Column(name = "name", nullable = true, length = 256)
	public String getName () {
		return name;
	}

	public EventTypeEntity setName (String name) {
		this.name = name;
		return this;
	}

	@Basic
	@Column(name = "description", nullable = true, length = 512)
	public String getDescription () {
		return description;
	}

	public EventTypeEntity setDescription (String description) {
		this.description = description;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(id, name, description);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		EventTypeEntity that = (EventTypeEntity)o;
		return id == that.id && Objects.equals(name, that.name)
			&& Objects.equals(description, that.description);
	}

	@Override
	public String toString () {
		return "EventTypeEntity { " + "id=" + id + ", name='" + name + '\''
			+ ", description='" + description + '\'' + " }";
	}
}
