
public class Event implements Comparable<Event>{
	//An event class which stores all the related information related to an event
	private Double startTime;
	private Double endTime;
	
	public Event(double startTime, double endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Double getStartTime() {
		return startTime;
	}
	public void setStartTime(Double startTime) {
		this.startTime = startTime;
	}
	public Double getEndTime() {
		return endTime;
	}
	public void setEndTime(Double endTime) {
		this.endTime = endTime;
	}
	@Override
	public  int compareTo(Event e) {
		// TODO Auto-generated method stub
		 if(this.endTime-e.endTime<0){
			 return -1;
		 }
		 else if(this.endTime - e.endTime>0){
			 return 1;
		 }
		 else{
			 return 0;
		 }

	}
	
}
