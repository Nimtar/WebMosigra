package ru.mosigra.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "achievement", schema = "public", catalog = "mosigra")
public class AchievementEntity {
	private short id;
	private String name;
	private String description;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public short getId () {
		return id;
	}

	public AchievementEntity setId (short id) {
		this.id = id;
		return this;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 256)
	public String getName () {
		return name;
	}

	public AchievementEntity setName (String name) {
		this.name = name;
		return this;
	}

	@Basic
	@Column(name = "description", nullable = true, length = 512)
	public String getDescription () {
		return description;
	}

	public AchievementEntity setDescription (String description) {
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
		AchievementEntity that = (AchievementEntity)o;
		return id == that.id && Objects.equals(name, that.name)
			&& Objects.equals(description, that.description);
	}

	@Override
	public String toString () {
		return "AchievementEntity{" + "id=" + id + ", name='" + name + '\''
			+ ", description='" + description + '\'' + '}';
	}
}
