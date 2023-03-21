package socialmedia;

// And this is a super long comment to test formatting
// 01234567891011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545556575859606162636465666768697071727374757677787980
/**
 * A class for comments. Stores comments and endorsement IDs that are made
 * relating to it by inheriting them from Post.
 * 
 * @author Jack Bundy
 * @version 1.0
 */
public class Comment extends Post {
    Integer commentedPost;

    /**
     * Constructor for Comment.
     * 
     * @param message
     * @param ownerId
     * @param commentedPost
     * @throws InvalidPostException
     * @throws PostIDNotRecognisedException
     */
    public Comment(String message, Integer ownerId, Integer commentedPost)
            throws InvalidPostException, PostIDNotRecognisedException {
        super(message, ownerId);
        // Comment is almost functionally the same as post
        this.commentedPost = commentedPost;
    }

    public Integer getCommentedPost() {
        return commentedPost;
    }
}