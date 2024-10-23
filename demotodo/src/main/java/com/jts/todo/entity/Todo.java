package com.jts.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo extends BaseEntity {

    private String title;
    private String description;
    private boolean completed;

    // Constructors
    public Todo() {}

    public Todo(String title, String description, boolean completed) {
        super(); // Inherits id, createdAt, updatedAt from BaseEntity
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // toString method
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + getId() +   // getId inherited from BaseEntity
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                '}';
    }

	private String getUpdatedAt() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getCreatedAt() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
