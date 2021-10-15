package kim.nikita.model;

import java.time.LocalDateTime;

public class Vote {

    private int id;
    private int userId;
    private int restaurantId;
    private LocalDateTime timeOfVote;
    private boolean current;

    public Vote(int id, int userId, int restaurantId, LocalDateTime timeOfVote, boolean current) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.timeOfVote = timeOfVote;
        this.current = current;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getTimeOfVote() {
        return timeOfVote;
    }

    public void setTimeOfVote(LocalDateTime timeOfVote) {
        this.timeOfVote = timeOfVote;
    }


    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
