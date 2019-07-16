
/*
 * This class used to handal exception when quantity is 
 * negative or 0.
 */
class InvalidUpdateException extends Exception {
    InvalidUpdateException(String s) {
        super(s);
    }
}