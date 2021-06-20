package com.example.AnotherQuizApp.ui.adapter;

public class ChapterData {

    private String chapterName;
    private String chapterContents;
    private Integer chapterImage;

    public ChapterData(String chapterName, String chapterContents, Integer chapterImage) {
        this.chapterName = chapterName;
        this.chapterContents = chapterContents;
        this.chapterImage = chapterImage;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterContents() {
        return chapterContents;
    }

    public void setChapterContents(String chapterContents) {
        this.chapterContents = chapterContents;
    }

    public Integer getChapterImage() {
        return chapterImage;
    }

    public void setChapterImage(Integer chapterImage) {
        this.chapterImage = chapterImage;
    }
}
