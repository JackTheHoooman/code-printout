package socialmedia;

import java.util.ArrayList;

/**
 * A class for posts. It store its message, id, comments, and endorsements.
 * Comments extend this class.
 * 
 * @author Jack Bundy
 * @version 1.0
 */
public class Post extends Interaction {
    private String message;
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private ArrayList<Endorsement> endorsements = new ArrayList<Endorsement>();

    /**
     * Post constructor
     * 
     * @param ownerId
     * @param message
     * @throws InvalidPostException
     */
    public Post(String message, Integer ownerId) throws InvalidPostException {
        super(ownerId);

        if (message.isEmpty() || message.length() > 100) {
            throw new InvalidPostException();
        } else {
            this.message = message;
        }
    }

    /**
     * Get list of comment IDs
     * 
     * @return arraylist of comment IDs
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Set the comment IDs
     * 
     * @param comments
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Add a new comment to the end of the list
     * 
     * @param comment_id
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * Get list of endorsement
     * 
     * @return array list of endorsement IDs
     */
    public ArrayList<Endorsement> getEndorsements() {
        return endorsements;
    }

    /**
     * Set the endorsement IDs
     * 
     * @param endorsements
     */
    public void setEndorsements(ArrayList<Endorsement> endorsements) {
        this.endorsements = endorsements;
    }

    /**
     * Add new id to endorsement ids
     * 
     * @param endorsement
     */
    public void addEndorsement(Endorsement endorsement) {
        endorsements.add(endorsement);
    }

    /**
     * Sets a new post message
     * 
     * @param message
     * @throws InvalidPostException
     */
    public void setMessage(String message) throws InvalidPostException {
        if (message.isEmpty() || message.length() > 100) {
            throw new InvalidPostException();
        } else {
            this.message = message;
        }
    }

    /**
     * Gets the Post message
     * 
     * @return
     */
    public String getMessage() {
        return message;
    }
}