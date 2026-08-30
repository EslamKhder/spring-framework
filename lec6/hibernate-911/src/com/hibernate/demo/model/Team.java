package com.hibernate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	private int playerCount;
	
	private boolean active;


	private String leader;
	
	
	public Team() {
		
	}
	
	public Team(Long id) {
		this.id = id;
	}

	public Team(String name, int playerCount, boolean active, String leader) {
		this.name = name;
		this.playerCount = playerCount;
		this.active = active;
		this.leader = leader;
	}
	public Team(Long id, String name, int playerCount, boolean active, String leader) {
		this.id = id;
		this.name = name;
		this.playerCount = playerCount;
		this.active = active;
		this.leader = leader;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}



	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", playerCount=" + playerCount + ", active=" + active + ", leader="
				+ leader + "]";
	}



	
	
	
	
}
