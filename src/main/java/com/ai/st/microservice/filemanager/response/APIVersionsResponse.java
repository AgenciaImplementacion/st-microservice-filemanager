package com.ai.st.microservice.filemanager.response;

import com.ai.st.microservice.filemanager.entity.VersionInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class APIVersionsResponse implements Serializable {

    private List<VersionInfo> versions;
    private String id = "IDEATFileManager";

    public APIVersionsResponse() {
        this.versions = new ArrayList<>();
    }

    public List<VersionInfo> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionInfo> versions) {
        this.versions = versions;
    }

    public void addVersion(String name, String url) {
        this.versions.add(new VersionInfo(name, url));
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

}
