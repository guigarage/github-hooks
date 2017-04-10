package com.guigarage.github.hooks.servlet;

import com.google.gson.Gson;
import com.guigarage.github.hooks.GitHubConstants;
import com.guigarage.github.hooks.SignatureCrypto;
import com.guigarage.github.hooks.model.GitHubEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.function.Consumer;

public class GitHubRequest {

    private final String content;

    private final String signature;

    private final String userAgent;

    private final String eventTypeName;

    private final String id;

    private GitHubRequest(final HttpServletRequest request) throws IOException {
        Objects.requireNonNull(request, "request should not be null!");

        this.id = extractId(request);
        this.signature = extractSignature(request);
        this.userAgent = extractUserAgent(request);
        this.eventTypeName = extractEventName(request);
        this.content = extractContent(request);
    }

    public static GitHubRequest of(final HttpServletRequest request) throws IOException {
        Objects.requireNonNull(request, "request should not be null!");

        return new GitHubRequest(request);
    }

    public GitHubRequest fullChecked(final String secret) {
        return signatureChecked(secret).idChecked().userAgentChecked();
    }

    public GitHubRequest idChecked() {
        if(id == null) {
            throw new SecurityException("GitHubRequest does not contain an ID");
        }
        return this;
    }

    public GitHubRequest userAgentChecked() {
        if(userAgent == null ) {
            throw new SecurityException("GitHubRequest does not contain an userAgent");
        }
        if(!userAgent.equals(GitHubConstants.GITHUB_USER_AGENT_VALUE) ) {
            throw new SecurityException("GitHubRequest contains wrong userAgent");
        }
        return this;
    }

    public GitHubRequest signatureChecked(final String secret) {
        Objects.requireNonNull(secret, "secret should not be null!");

        final boolean verified = SignatureCrypto.verifySignature(content, signature, secret);
        if(!verified) {
            throw new SecurityException("Signature of GitHubRequest does not match to given secret");
        }
        return this;
    }

    public GitHubRequest updateResponse(HttpServletResponse response, boolean ok) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        if(ok) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Guigarage Github-Hooks</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>OK</p>");
                out.println("</body>");
                out.println("</html>");
            }
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Guigarage Github-Hooks</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>OK</p>");
                out.println("</body>");
                out.println("</html>");
            }
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return this;
    }

    public <T extends GitHubEvent> GitHubRequest ifTypeOf(Class<T> eventType, Consumer<T> eventHandler) {
        if(isTypeOf(eventType)) {
            T event = convertTo(eventType);
            eventHandler.accept(event);
        }
        return this;
    }

    public <T extends GitHubEvent> T convertTo(Class<T> eventType) {
        if(isTypeOf(eventType)) {
            Gson gson = new Gson();
            T event = gson.fromJson(content, eventType);
            return event;
        } else {
            throw new IllegalStateException("Content of GitHub Request is not of type " + eventType);
        }
    }

    public <T extends GitHubEvent> boolean isTypeOf(Class<T> eventType) {
        Objects.requireNonNull(eventType, "eventType should not be null!");

        String assumedEventTypeName = GitHubConstants.getNameForEventType(eventType);
        return assumedEventTypeName.equals(eventTypeName);
    }

    private String extractEventName(HttpServletRequest request) {
        Objects.requireNonNull(request, "request should not be null!");

        return request.getHeader(GitHubConstants.GITHUB_EVENT_NAME_HEADER);
    }

    private String extractSignature(HttpServletRequest request) {
        Objects.requireNonNull(request, "request should not be null!");

        return request.getHeader(GitHubConstants.GITHUB_SIGNATURE_HEADER);
    }

    private String extractId(HttpServletRequest request) {
        Objects.requireNonNull(request, "request should not be null!");

        return request.getHeader(GitHubConstants.GITHUB_ID_HEADER);
    }

    private String extractUserAgent(HttpServletRequest request) {
        Objects.requireNonNull(request, "request should not be null!");

        return request.getHeader(GitHubConstants.GITHUB_USER_AGENT_HEADER);
    }

    private String extractContent(HttpServletRequest request) throws IOException {
        Objects.requireNonNull(request, "request should not be null!");

        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
