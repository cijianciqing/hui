package jsjzx.wlyw.huitest.beans;

public class SearchInfo {

    private Integer pageSize;
    private Integer pageNumber;
    private String searchText;
    private String sortName;
    private String sortOrder;
    private String userNameSearch;
    private String nickNameSearch;

    public String getUserNameSearch() {
        return userNameSearch;
    }

    public void setUserNameSearch(String userNameSearch) {
        this.userNameSearch = userNameSearch;
    }

    public String getNickNameSearch() {
        return nickNameSearch;
    }

    public void setNickNameSearch(String nickNameSearch) {
        this.nickNameSearch = nickNameSearch;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", searchText='" + searchText + '\'' +
                ", sortName='" + sortName + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", userNameSearch='" + userNameSearch + '\'' +
                ", nicknameSearch='" + nickNameSearch + '\'' +
                '}';
    }
}
