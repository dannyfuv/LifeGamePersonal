package com.tsi.lifegame.core;

class Cell{

	private boolean isAlive;
	private int numberOfNeighbours;
    
    /**
        Constructor Method
    */
	public Cell() {
		isAlive = true;
	}
    
    /**
        Kills an alive cell
    */
	void Kill() {
		this.isAlive = false;
	}
		
    /**
        Assign to cell number of alive neighbours 
    */   
	void AssignNumberOfNeighboursAlive(int numberOfNeighboursAlive){
		
		this.numberOfNeighbours = numberOfNeighboursAlive;	
	}
    
    /**
        return if cell is alive (alive = true ; dead = false)
    */
     boolean getIsAlive(){
        return this.isAlive;
    }
    
    /**
        return the cell's number of neighbours alive
    */
    int getNumberOfNeighbours(){
        return this.numberOfNeighbours;
    }
    
    /**
        Complete all possible transitions of the cell
    */
    void Tick(){
    
        if(isAlive){            
            if(this.numberOfNeighbours < 2){
                this.isAlive = false;
            }else{
                if(this.numberOfNeighbours >= 2 && this.numberOfNeighbours <= 3){
                    this.isAlive = true;
                }
                else {
                   if (this.numberOfNeighbours > 3) {
                      this.isAlive = false;
                   }
                }
            }
        }
        else {
           if (this.numberOfNeighbours == 3) {
              this.isAlive=true;
           }else{
                this.isAlive=false;
           }
        }
    }
}
