package com.guigarage.github.hooks;

import com.guigarage.github.hooks.model.GitHubEvent;
import com.guigarage.github.hooks.model.GitHubPushEvent;

import java.util.Objects;

public interface GitHubConstants {

    //See https://developer.github.com/webhooks/#payloads

    String GITHUB_EVENT_NAME_HEADER = "X-GitHub-Event";

    String GITHUB_SIGNATURE_HEADER = "X-Hub-Signature";

    String GITHUB_ID_HEADER = "X-GitHub-Delivery";

    String GITHUB_USER_AGENT_HEADER = "user-agent";

    String GITHUB_USER_AGENT_VALUE = "GitHub-Hookshot";



    //See https://developer.github.com/webhooks/#events

    String GITHUB_EVENT_TYPE_WILDCARD = "*";

    String GITHUB_EVENT_TYPE_COMMIT_COMMENT = "commit_comment";

    String GITHUB_EVENT_TYPE_CREATE = "create";

    String GITHUB_EVENT_TYPE_PUSH = "push";

    static <T extends GitHubEvent> String getNameForEventType(Class<T> eventType) {
        Objects.requireNonNull(eventType, "eventType should not be null!");
        if(eventType.equals(GitHubPushEvent.class)) {
            return GITHUB_EVENT_TYPE_PUSH;
        }
        throw new IllegalArgumentException("Given type " + eventType + " is not supported!");
    }
}
