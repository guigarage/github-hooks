package com.guigarage.github.hooks.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GitHubCommit implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("tree_id")
    private String tree_id;

    @SerializedName("distinct")
    private boolean distinct;

    @SerializedName("message")
    private String message;

    @SerializedName("timestamp")
    private String timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTree_id() {
        return tree_id;
    }

    public void setTree_id(String tree_id) {
        this.tree_id = tree_id;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
