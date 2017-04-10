package com.guigarage.github.hooks.servlet;

import com.guigarage.github.hooks.GitHubConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class RequestMockFactory {

    public static HttpServletRequest createWithInvalidSecret() {
        HttpServletRequestMock mock = new HttpServletRequestMock();
        mock.setContent("");
        mock.setSignature(GitHubTestConstants.INVALID_SIGNATURE);
        mock.setUserAgent(GitHubConstants.GITHUB_USER_AGENT_VALUE);
        mock.setEventType(GitHubConstants.GITHUB_EVENT_TYPE_PUSH);
        mock.setId(UUID.randomUUID().toString());
        return mock;
    }

    public static HttpServletRequest create() {
        HttpServletRequestMock mock = new HttpServletRequestMock();
        mock.setContent("");
        mock.setSignature(GitHubTestConstants.VALID_SIGNATURE);
        mock.setUserAgent(GitHubConstants.GITHUB_USER_AGENT_VALUE);
        mock.setEventType(GitHubConstants.GITHUB_EVENT_TYPE_PUSH);
        mock.setId(UUID.randomUUID().toString());
        return mock;
    }


}
