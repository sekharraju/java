package com.dev.jk.java.domain;

public class DomainResponse {

    private StringBuilder content = new StringBuilder();

    public StringBuilder getContent() {
        return content;
    }

    public DomainResponse appendContent(String content) {
        this.content.append(content);
        return this;
    }
}
