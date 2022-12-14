package com.example.model;


public class MailForm {
    private Integer id;
    private String languageName;
    private Integer pageSize;
    private boolean filter;
    private String description;
    private Integer isDelete;

    public MailForm(Integer id, String languageName, Integer pageSize, boolean filter, String description, Integer isDelete) {
        this.id = id;
        this.languageName = languageName;
        this.pageSize = pageSize;
        this.filter = filter;
        this.description = description;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
