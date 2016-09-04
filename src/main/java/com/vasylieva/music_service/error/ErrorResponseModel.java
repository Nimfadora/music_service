package com.vasylieva.music_service.error;

import java.util.List;

import static java.lang.String.format;

public class ErrorResponseModel {
    private String code;
    private String summary;
    private String details;
    private List<?> metadata;

    public ErrorResponseModel() {
    }

    private ErrorResponseModel(String code, String summary, String details,
                               List<?> metadata) {
        this.code = code;
        this.summary = summary;
        this.details = details;
        this.metadata = metadata;
    }

    public String getCode() {
        return code;
    }

    public String getSummary() {
        return summary;
    }

    public String getDetails() {
        return details;
    }

    public List<?> getMetadata() {
        return metadata;
    }

    public static class Builder {
        private String code;
        private String summary;
        private String details;
        private List<?> metadata;

        public Builder() {
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder setDetails(String details) {
            this.details = details;
            return this;
        }

        public Builder setMetadata(List<?> metadata) {
            this.metadata = metadata;
            return this;
        }

        public ErrorResponseModel build() {
            return new ErrorResponseModel(code, summary, details, metadata);
        }
    }

    @Override
    public String toString() {
        return format("ErrorResponseModel{code='%s', summary='%s', details='%s', metadata=%s}",
                code, summary, details, metadata);
    }
}
