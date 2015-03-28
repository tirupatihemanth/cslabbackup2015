import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class LectureScheduling {
	
	private static Scanner input;
	private static double startTime, endTime;
	public static void main(String[] args){
		input = new Scanner(System.in);
		int numOfPeople = input.nextInt();
		int numOfEvents = input.nextInt();
		int eventsAttended=0;
		input.nextLine();
		ArrayList<Event> events = new ArrayList<Event>(numOfEvents);
		Double[] lastEventEndTime = new Double[numOfPeople];
		for(int i=0;i<numOfPeople;i++){
			lastEventEndTime[i] = 0.0;
		}
		for(int i=0;i<numOfEvents;i++){
			getParsedTime();
			//System.out.println("startTime: "+startTime+" endTime"+endTime);
			events.add(new Event(startTime, endTime));
		}
		
		Collections.sort(events);
		Double min;
		int index=0,stat=0;
		//Being greedy on finishing time
		for(int i=0;i<numOfEvents;i++){
			min = Double.MAX_VALUE;
			stat=0;
			for(int j=0;j<numOfPeople;j++){
				if(events.get(i).getStartTime()>=lastEventEndTime[j]){
					if(events.get(i).getStartTime()-lastEventEndTime[j]<min){
						stat = 1;
						index = j;
						min = events.get(i).getStartTime()-lastEventEndTime[j];
					}
				}
			}
			if(stat == 1){
				lastEventEndTime[index] = events.get(i).getEndTime();
				eventsAttended++;
			}

		}
		
		System.out.println(eventsAttended);
	}

	private static void getParsedTime(){
		// TODO Parse the given input String
		String[] inStr = input.nextLine().split(" |:");
		if(Integer.parseInt(inStr[0])<8){
			startTime = 12 + Integer.parseInt(inStr[0]);
		}
		else{
			startTime = Integer.parseInt(inStr[0]);
		}
		startTime+=Integer.parseInt(inStr[1])/100.0;
		
		if(Integer.parseInt(inStr[2])>=8){
			if(Integer.parseInt(inStr[2])==8 && Integer.parseInt(inStr[3])==0){
				endTime = 20.0;
			}
			else{
				endTime = Integer.parseInt(inStr[2]);
			}
		}
		else{
			endTime = 12 + Integer.parseInt(inStr[2]);
		}
		
		endTime += Integer.parseInt(inStr[3])/100.0;
	}
}
