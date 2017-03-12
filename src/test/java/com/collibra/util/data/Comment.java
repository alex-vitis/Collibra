package com.collibra.util.data;

/**
 * Created by vitis on 11.03.2017.
 */
public class Comment {
    private String commenterName;
    private String commenterEmail;
    private String commentBody;
    private int postId;

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }


    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterEmail(String commenterEmail) {
        this.commenterEmail = commenterEmail;
    }


    public String getCommenterEmail() {
        return commenterEmail;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }


    public String getCommentBody() {
        return commentBody;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
    }
}