package saioapi.comm.v2;

/**
 * The listener that handle notifications when an event is triggered.
 */
public interface OnComEventListener
{
    /**
     * Callback method would be invoked when an event is triggered.
     * Please implement UI behavior in UI thread, not in this method.
     *
     * <p>
     *     Note: The data reading and event listener method are executed in the same thread.
     *           When using the VNG protocol to communicate with EPP, if you call write() in the event listener, it will block the thread until the write timeout.
     *           Before writing timout, the thread cannot read and analyze the data, and thus cannot send ack to Epp in time, causing Epp to send the responses three times (retry).
     *           The way to solve this situation is to create another thread in the event listener to write command.
     * </p>
     *
     * @param event Indicates the event defined in service class constants.
     */
    void onEvent(int event);
}
