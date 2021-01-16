package com.cooksys.ftd.assignments.collections.model;

import com.cooksys.ftd.assignments.collections.util.MissingImplementationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * TODO: Implement this class
 *  <br><br>
 *  A worker is a type of employee that cannot be a superior to another employee.
 *  <br>
 *  A worker should have a name, and, optionally, a manager superior to them.
 */
public class Worker implements Employee {

    private String name;
    private Manager superManager;

    /**
     * TODO: Implement this constructor.
     *
     * @param name the name of the worker to be created
     */
    public Worker(String name) {
        this.name = name;
        superManager = null;
    }

    /**
     *  TODO: Implement this constructor.
     *
     * @param name the name of the worker to be created
     * @param manager the direct manager of the worker to be created
     */
    public Worker(String name, Manager manager) {
        this.name = name;
        superManager = manager;
    }

    /**
     * TODO: Implement this getter.
     *
     * @return the name of the worker
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * TODO: Implement this getter.
     *
     * @return {@code true} if this worker has a manager, or {@code false} otherwise
     */
    @Override
    public boolean hasManager() {
        if(superManager == null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * TODO: Implement this getter.
     *
     * @return the manager of this worker, or null if it has none
     */
    @Override
    public Manager getManager() {
        if(superManager==null){
            return null;
        }else{
            return superManager;
        }
    }

    /**
     * TODO: Implement this method.
     *  <br><br>
     *  Retrieves the worker's chain of command as a {@code List<Manager>}, starting with their direct {@code Manager},
     *  followed by that {@code Manager}'s {@code Manager}, and so on, until the top of the hierarchy is reached.
     *  <br><br>
     *  The returned list should never be or contain {@code null}.
     *  <br><br>
     *  If the worker does not have a {@code Manager}, an empty
     *  {@code List<Manager>} should be returned.
     *
     * @return a {@code List<Manager>} that represents the worker's chain of command,
     */
    @Override
    public List<Manager> getChainOfCommand() {
        Manager superduperManager = superManager;
        List<Manager> managerList = new ArrayList<>();
        if(hasManager()==false){
            return managerList;
        }
        managerList.add(superManager);
        while(superduperManager.hasManager()){
            managerList.add(superduperManager.getManager());
            superduperManager = superduperManager.getManager();

        }
        return managerList;
    }

    // TODO: Does this class need custom .equals() and .hashcode() methods? If so, implement them here.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name) &&
                Objects.equals(superManager, worker.superManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, superManager);
    }


    // TODO [OPTIONAL]: Consider adding a custom .toString() method here if you want to debug your code with System.out.println() statements
}
