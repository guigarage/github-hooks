package com.guigarage.github.hooks.servlet;

import com.guigarage.github.hooks.GitHubConstants;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public class HttpServletRequestMock implements HttpServletRequest {

    private String content;

    private String signature;

    private String userAgent;

    private String eventType;

    private String id;

    @Override
    public String getAuthType() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Cookie[] getCookies() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public long getDateHeader(String name) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getHeader(String name) {
        if(GitHubConstants.GITHUB_EVENT_NAME_HEADER.equals(name)) {
            return eventType;
        }
        if(GitHubConstants.GITHUB_ID_HEADER.equals(name)) {
            return id;
        }
        if(GitHubConstants.GITHUB_SIGNATURE_HEADER.equals(name)) {
            return signature;
        }
        if(GitHubConstants.GITHUB_USER_AGENT_HEADER.equals(name)) {
            return userAgent;
        }
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public int getIntHeader(String name) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getMethod() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getPathInfo() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getPathTranslated() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getContextPath() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getQueryString() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getRemoteUser() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public boolean isUserInRole(String role) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Principal getUserPrincipal() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getRequestedSessionId() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getRequestURI() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public StringBuffer getRequestURL() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getServletPath() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public HttpSession getSession(boolean create) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public HttpSession getSession() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String changeSessionId() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public void login(String username, String password) throws ServletException {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public void logout() throws ServletException {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Part getPart(String name) throws IOException, ServletException {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Object getAttribute(String name) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getCharacterEncoding() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public int getContentLength() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public long getContentLengthLong() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getContentType() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getParameter(String name) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Enumeration<String> getParameterNames() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String[] getParameterValues(String name) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getProtocol() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getScheme() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getServerName() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public int getServerPort() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new StringReader(content));
    }

    @Override
    public String getRemoteAddr() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getRemoteHost() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public void setAttribute(String name, Object o) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public void removeAttribute(String name) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Locale getLocale() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public Enumeration<Locale> getLocales() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public boolean isSecure() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getRealPath(String path) {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public int getRemotePort() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getLocalName() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public String getLocalAddr() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public int getLocalPort() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public ServletContext getServletContext() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public boolean isAsyncStarted() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public boolean isAsyncSupported() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public AsyncContext getAsyncContext() {
        throw new RuntimeException("Method not supported in mock");
    }

    @Override
    public DispatcherType getDispatcherType() {
        throw new RuntimeException("Method not supported in mock");
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setId(String id) {
        this.id = id;
    }
}
