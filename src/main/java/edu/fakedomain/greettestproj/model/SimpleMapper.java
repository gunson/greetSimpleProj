/*
 * George Un 
 */
package edu.fakedomain.greettestproj.model;

/**
 *
 * @author George Un
 */
public interface SimpleMapper {

    Message findMessageByID(int id);

    /**
     * 
     * @return returns number of rows in the table
     */
    int checkIfDataExist();

    /**
     * To create table on first run if not exists
     */
    void createTable();

    /**
     * To populate table on first run
     */
    void populateTable();

    /**
     * Simple project. No need to pass id.
     *
     * @param newMsg -- new message
     */
    void updateMessage(String newMsg);
}
