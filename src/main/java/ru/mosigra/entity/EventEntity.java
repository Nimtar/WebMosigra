package ru.mosigra.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetTime;
import java.util.Objects;

@Entity
@Table(name = "event", schema = "public", catalog = "mosigra")
public class EventEntity {
	private short id;
	private LocalDate date;
	private OffsetTime time;
	private String description;
	private String name;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	public short getId () {
		return id;
	}

	public EventEntity setId (short id) {
		this.id = id;
		return this;
	}

	@Basic
	@Column(name = "date", nullable = false)
	public LocalDate getDate () {
		return date;
	}

	public EventEntity setDate (LocalDate date) {
		this.date = date;
		return this;
	}

	@Basic
	@Column(name = "time", nullable = true)
	public OffsetTime getTime () {
		return time;
	}

	public EventEntity setTime (OffsetTime time) {
		this.time = time;
		return this;
	}

	@Basic
	@Column(name = "description", nullable = true, length = 512)
	public String getDescription () {
		return description;
	}

	public EventEntity setDescription (String description) {
		this.description = description;
		return this;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 256)
	public String getName () {
		return name;
	}

	public EventEntity setName (String name) {
		this.name = name;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(id, date, time, description, name);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		EventEntity that = (EventEntity)o;
		return id == that.id && Objects.equals(date, that.date)
			&& Objects.equals(time, that.time) && Objects.equals(description,
			that.description) && Objects.equals(name, that.name);
	}

	@Override
	public String toString () {
		return "EventEntity { " + "id=" + id + ", date=" + date + ", time="
			+ time + ", description='" + description + '\'' + ", name='" + name
			+ '\'' + " }";
	}
}
