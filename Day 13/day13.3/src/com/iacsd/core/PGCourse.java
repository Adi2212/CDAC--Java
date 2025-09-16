package com.iacsd.core;

public enum PGCourse {
	CORE_JAVA(75,90), DBT(70,60), PYTHON(60,120) , MERN(85,50), WEB_JAVA(85,60),DEV_OPS(85,50);

	private int minMarks;
	private int maxCapacity;
	private int availableSeats;
	
	public int getAvailableSeats() {
		return availableSeats;
	}


	private PGCourse(int minMarks, int maxCapacity) {
		this.minMarks = minMarks;
		this.maxCapacity = maxCapacity;
		this.availableSeats=maxCapacity;
	}


	public int getMaxCapacity() {
		return maxCapacity;
	}


	


	public int getMinMarks() {
		return minMarks;
	}


	public void freeSeat() {
		if (availableSeats < maxCapacity) {
            availableSeats++;
        }
		
	}
	
	


	 public boolean allocateSeat() {
	        if (availableSeats > 0) {
	            availableSeats--;
	            return true;
	        }
	        return false;
	    }
	
	
	

	

}
