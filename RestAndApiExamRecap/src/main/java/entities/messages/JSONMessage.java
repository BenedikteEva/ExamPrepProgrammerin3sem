/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.messages;

/**
 *
 * @author bladt
 */
public interface JSONMessage<T> {
    public T toInternal();
}
