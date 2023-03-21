package socialmedia;

/**
 * An abstract class for Post, Comments and Endorsements to extend.
 * Allows the storage of each of them inside a single ArrayList
 * 
 * Also contains a static integer for finding the last created interaction to
 * save computation.
 * Used to prevent re-use of deleted account comments.
 * 
 * @author Jack Bundy
 * @version 1.0
 */
public abstract class Interaction implements java.io.Serializable {
    // Used to be an interface but lastCreatedInteractionId was needed
    // to NOT be final.
    // The lack of database is so great /s

    private Integer id;
    private Integer ownerId;
    /**
     * static integer for the last created interaction ID.
     * For finding out what the next ID should be in timeline
     */
    public static Integer lastCreatedInteractionId = 0;

    /**
     * Constructor for Interaction
     * 
     * @param ownerId
     */
    public Interaction(Integer ownerId) {
        this.id = ++lastCreatedInteractionId;

        this.ownerId = ownerId;
    }

    /**
     * Get interaction ID
     * 
     * @return Interaction ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Get interaction owner ID
     * 
     * @return Interaction Owner ID
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * Sets a new owner ID
     * 
     * @param ownerId
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
