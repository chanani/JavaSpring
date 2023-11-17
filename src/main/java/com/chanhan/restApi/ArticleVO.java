package com.chanhan.restApi;

public class ArticleVO {

    private Integer articleNO;
    private String writer;
    private String title;
    private String content;

    public Integer getArticleNO() {
        return articleNO;
    }

    public void setArticleNO(Integer articleNO) {
        this.articleNO = articleNO;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
