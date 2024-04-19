package com.recipemanagement.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String category;

    @Column(length = 2000)
    private String ingredients;

    @Column(length = 2000)
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
        name = "recipe_user",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> sharedWith = new HashSet<>();

    // Constructors
    public Recipe() {
    }

    public Recipe(String title, String description, String category, String ingredients, String instructions, User user) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.user = user;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(Set<User> sharedWith) {
        this.sharedWith = sharedWith;
    }

    // Add methods to manipulate sharedWith set
    @SuppressWarnings("unchecked")
	public void shareWithUser(User user) {
        sharedWith.add(user);
        user.getSharedRecipes().addAll((Collection<? extends User>) this);
    }

    @SuppressWarnings("unlikely-arg-type")
	public void unshareWithUser(User user) {
        sharedWith.remove(user);
        user.getSharedRecipes().remove(this);
    }
}
