package ru.mosigra.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "game", schema = "public", catalog = "mosigra")
public class GameEntity {
	private String name;
	private short id;
	private String description;

	@Basic
	@Column(name = "name", nullable = false, length = 256)
	public String getName () {
		return name;
	}

	public GameEntity setName (String name) {
		this.name = name;
		return this;
	}

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public short getId () {
		return id;
	}

	public GameEntity setId (short id) {
		this.id = id;
		return this;
	}

	@Basic
	@Column(name = "description", nullable = true, length = 512)
	public String getDescription () {
		return description;
	}

	public GameEntity setDescription (String description) {
		this.description = description;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(name, id, description);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		GameEntity that = (GameEntity)o;
		return id == that.id && Objects.equals(name, that.name)
			&& Objects.equals(description, that.description);
	}

	@Override
	public String toString () {
		return "GameEntity { " + "name='" + name + '\'' + ", id=" + id
			+ ", description='" + description + '\'' + " }";
	}
}
