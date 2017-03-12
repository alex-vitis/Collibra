package com.collibra.test;

import com.collibra.util.JsonReader;
import com.collibra.util.RestApiResponce;
import com.collibra.util.data.Comment;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by vitis on 11.03.2017.
 */
public class CommentTest extends RestBaseTest {

    private ArrayList<Comment> allComments;

    @Test
    public void getComments() {
        // validate status
        RestApiResponce resp = validate(server.getCommentsFromServer());
        int size = JsonReader.countNumOfElem(resp);
        boolean exist = false;
        Comment cm = new Comment();
        // More then 0 elements in response
        Assert.assertTrue(size > 0);
        System.out.println("There are " + size + " elements in output!");
        allComments = new ArrayList<Comment>(size);
        for (int i = 0; i < size; i++) {
            cm = JsonReader.readComment(resp, i);
            if (cm.getCommenterEmail().equals("Jayne_Kuhic@sydney.com"))
                exist = true;
            allComments.add(cm);
        }
        // Second check that email "Jayne_Kuhic@sydney.com" exist in Response
        Assert.assertTrue(exist);
        // filtering out elements
        updateComments(allComments);
        System.out.println("There are " + allComments.size() + " elements in collection after filtering out!\n");
    }

    @Ignore
    @Test
    public void addPost() {
        // No sense for any complicated checks, case seems either POST request is just a mock, either they are deleting this 101st element immediately
        // it's not really added and not available by GET/id. Checked that same for POST - postComment
        validate(server.addPostToServer(33, "test Collibra", "This is my test POST request"));
    }

    // Remove all comments with postId!=1 and that don't contain "non" in body
    public ArrayList<Comment> updateComments(ArrayList<Comment> comments) {
        Comment temp = new Comment();
        Iterator<Comment> iter = comments.iterator();
        while (iter.hasNext()) {
            temp = iter.next();
            if ((temp.getPostId() != 1) || !temp.getCommentBody().contains("non")) {
                iter.remove();
            }
        }
        return comments;
    }
}
