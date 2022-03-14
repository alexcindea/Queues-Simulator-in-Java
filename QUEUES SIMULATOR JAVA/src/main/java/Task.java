public class Task {
    private int arrivalTime;
    private int processingTime;
    private int customerID;

    public Task(int arrivalTime, int processingTime, int customerID) {
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
        this.customerID = customerID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
