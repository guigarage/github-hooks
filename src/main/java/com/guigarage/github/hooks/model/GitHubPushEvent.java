package com.guigarage.github.hooks.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GitHubPushEvent implements GitHubEvent {

    @SerializedName("ref")
    private String reference;

    @SerializedName("before")
    private String before;

    @SerializedName("after")
    private String after;

    @SerializedName("created")
    private boolean created;

    @SerializedName("deleted")
    private boolean deleted;

    @SerializedName("forced")
    private boolean forced;

    @SerializedName("base_ref")
    private String base_ref;

    @SerializedName("compare")
    private String compare;

    @SerializedName("commits")
    private List<GitHubCommit> commits = new ArrayList<>();

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isForced() {
        return forced;
    }

    public void setForced(boolean forced) {
        this.forced = forced;
    }

    public String getBase_ref() {
        return base_ref;
    }

    public void setBase_ref(String base_ref) {
        this.base_ref = base_ref;
    }

    public String getCompare() {
        return compare;
    }

    public void setCompare(String compare) {
        this.compare = compare;
    }

    public List<GitHubCommit> getCommits() {
        return commits;
    }

    public void setCommits(List<GitHubCommit> commits) {
        this.commits = commits;
    }
}
