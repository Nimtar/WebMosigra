package ru.mosigra.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "condition", schema = "public", catalog = "mosigra")
public class ConditionEntity {
	private short id;
	private String name;
	private String description;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	public short getId () {
		return id;
	}

	public ConditionEntity setId (short id) {
		this.id = id;
		return this;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 256)
	public String getName () {
		return name;
	}

	public ConditionEntity setName (String name) {
		this.name = name;
		return this;
	}

	@Basic
	@Column(name = "description", nullable = true, length = 512)
	public String getDescription () {
		return description;
	}

	public ConditionEntity setDescription (String description) {
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
		ConditionEntity that = (ConditionEntity)o;
		return id == that.id && Objects.equals(name, that.name)
			&& Objects.equals(description, that.description);
	}

	@Override
	public String toString () {
		return "ConditionEntity{" + "id=" + id + ", name='" + name + '\''
			+ ", description='" + description + '\'' + '}';
	}
}
