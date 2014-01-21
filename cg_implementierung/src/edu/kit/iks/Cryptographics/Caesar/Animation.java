package edu.kit.iks.Cryptographics.Caesar;

public interface Animation
{
    /** Animation wird unendlich oft abgespielt */
    static final int ENDLESS_REPEAT_RATE = 0;
    
    /**
     * @param filename
     * @param time
     */
    void addScene(String filename, long time);
    
    /**
     * @param repeatRate
     */
    void start(int repeatRate);
 
    void stop();
 
    void reset();
}
