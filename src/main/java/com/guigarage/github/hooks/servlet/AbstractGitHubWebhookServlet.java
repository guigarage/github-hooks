package com.guigarage.github.hooks.servlet;

import com.guigarage.github.hooks.model.GitHubPushEvent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractGitHubWebhookServlet extends HttpServlet {

    private final String secret;

    public AbstractGitHubWebhookServlet(String secret) {
        this.secret = secret;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        GitHubRequest request = GitHubRequest.of(req);
        try {
            if(secret != null) {
                request.fullChecked(secret);
            }
            request.ifTypeOf(GitHubPushEvent.class, e -> onPushEvent(e));
            request.updateResponse(resp, true);
        } catch (Exception e) {
            request.updateResponse(resp, false);
        }
    }

    protected void onPushEvent(GitHubPushEvent e) {

    }
}
